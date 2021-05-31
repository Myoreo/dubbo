/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.provider;

import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.bean.GoodsType;
import org.apache.dubbo.rpc.RpcContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    private AtomicInteger incCounter = new AtomicInteger(0);

    @Override
    public String sayHello(String name) {
        logger.info("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        /*try {
            Random random = new Random();
            Thread.sleep(2000 + random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress() + ",you are " + incCounter.incrementAndGet();
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return sayHello(name);
        });
        return cf;
    }

    @Override
    public GoodsType get() {
        return GoodsType.Phone;
    }
}
