package org.apache.dubbo.rpc.protocol.dubbo.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

/**
 * @Author : xuaoping
 * @Date: 2020/11/26
 */
@Activate(group = CommonConstants.CONSUMER)
public class ConsumerTrackingFilter implements Filter {
    private  static Logger logger = LoggerFactory.getLogger(ConsumerTrackingFilter.class);

    public ConsumerTrackingFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            RpcContext.getContext().setAttachment("logKey", "unique");
        } catch (Throwable var4) {
            logger.warn("ConsumerTrackingFilter error", var4);
        }

        Result result = invoker.invoke(invocation);
        return result;
    }
}
