package com.metaphor.commons.http;

import com.metaphor.commons.annotations.CacheControl;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Provider
@CacheControl
public class CacheControlFilter implements ContainerResponseFilter {
    private static final int ONE_YEAR_IN_SECONDS = (int) TimeUnit.DAYS.toSeconds(365);
    private static final int THIRTY_MINUTES_IN_SECONDS = (int) TimeUnit.MINUTES.toSeconds(30);
    private final ResourceInfo resourceInfo;

    public CacheControlFilter(@Context ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

        Response.Status status = Response.Status.fromStatusCode(responseContext.getStatus());
        if (status != Response.Status.OK) {
            return;
        }

        CacheControl control = resourceInfo.getResourceMethod().getAnnotation(CacheControl.class);

        if (control != null) {
            javax.ws.rs.core.CacheControl cacheControl = new javax.ws.rs.core.CacheControl();
            cacheControl.setPrivate(control.isPrivate());
            cacheControl.setNoCache(control.noCache());
            cacheControl.setNoStore(control.noStore());
            cacheControl.setNoTransform(control.noTransform());
            cacheControl.setMustRevalidate(control.mustRevalidate());
            cacheControl.setProxyRevalidate(control.proxyRevalidate());
            cacheControl.setSMaxAge((int) control.sharedMaxAgeUnit().toSeconds(control.sharedMaxAge()));
            cacheControl.setMaxAge((int) control.maxAgeUnit().toSeconds(maxAge(control)));
            responseContext.getHeaders().add(HttpHeaders.CACHE_CONTROL, cacheControl);
        }
    }

    private int maxAge(CacheControl control) {
        if (control.immutable()) {
            return ONE_YEAR_IN_SECONDS;
        }

        int maxAge = control.maxAge();
        if (maxAge < 0) {
            return THIRTY_MINUTES_IN_SECONDS;
        }

        return maxAge;
    }

}
