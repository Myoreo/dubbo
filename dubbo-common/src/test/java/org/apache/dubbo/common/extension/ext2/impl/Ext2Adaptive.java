package org.apache.dubbo.common.extension.ext2.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.ext2.Ext2;
import org.apache.dubbo.common.extension.ext2.UrlHolder;

/**
 * @Author : xuaoping
 * @Date: 2021/5/6
 */
public class Ext2Adaptive implements Ext2 {
    public java.lang.String echo(UrlHolder arg0, String arg1) {
        if (arg0 == null)
            throw new IllegalArgumentException("org.apache.dubbo.common.extension.ext2.UrlHolder argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("org.apache.dubbo.common.extension.ext2.UrlHolder argument getUrl() == null");
        URL url = arg0.getUrl();
        String extName = url.getParameter("ext2", "impl1");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.common.extension.ext2.Ext2) name from url (" + url.toString() + ") use keys([ext2])");
        Ext2 extension = ExtensionLoader.getExtensionLoader(Ext2.class).getExtension(extName);
        return extension.echo(arg0, arg1);
    }

    public java.lang.String bang(org.apache.dubbo.common.URL arg0, int arg1) {
        throw new UnsupportedOperationException("The method public abstract java.lang.String org.apache.dubbo.common.extension.ext2.Ext2.bang(org.apache.dubbo.common.URL,int) of interface org.apache.dubbo.common.extension.ext2.Ext2 is not adaptive method!");
    }
}
