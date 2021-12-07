package com.dark.util;

import com.github.pagehelper.PageInfo;

import java.util.UUID;

public final class Tools {
    public static final Integer STATUSERROR = 0;
    public static final Integer SUCCESS = 1;
    public static final Integer FAILED = 2;
    public static final Integer SQLERROR = 3;
    public static final Integer DATANULL = 4;
    public static final Integer UNLOGIN = 5;

    public static final String APP_ID = "2021000118660954";
    public static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCHsAPZxNcO9u6TQZTbD3NLMzjHMV1IWtFqrXd1CNisqNECCpmL2jxd+lFJBnT64yfk4jLSYFThK1qJXTElUxZZQQG5j7DziNEQcs1yK7yU2D74dHMeBPEIzzTNxV43MpeW33iQPlR9bKg7I5Gg2eQwlcvgSVvxv8GJS7aM5iY0y5IqVUbLxyIJQ16Ik42mVW84oVOhEvQK554nnM5ZAqvtuYEVm9BwgIvW0BbJ7Xg7zTREfraYsJtY1L8pWTf1TNfripOIFD+xKYeKUYWUEmTw37uha76gU8uTZF8QYFNP7FdzpNbK259MPOxbnhc009GrET2YMHT8VsxUMVMCv9q5AgMBAAECggEAOGqN31DBnl47agy9iKuO43iDpga3Y2snYXSIk6e+92Mlq/SeTRDLQsPeYj+GCf7Cyp7mRKR7BjhRZ4XQ9lTqmOe3gODm0QtU6cLh+xOGUFjtLb61Uoj5cxE8QkZK2yZ08u0tosPXu2KfPB+Y4ElYYH8YCsRVr1lsbdqGJ2VWA2L3pK3AaX4o6SsU7l7Y6KMsybWmc5hnJqzfr0a6Fg+i7r1WAj5A/n36tJeJnhst6GlUivx18D+0VOC4KU7blkd/mzclc0gZz+04GwhJnL5TNPJU60fFJFEVkhaUBsxWVfxPjsqGaxiUFtkfZtk563EjffmoFVjBSUjuQL/S6eQjtQKBgQDd5OYsJmyEfVefKxDNx4bCfUiMhlpRgcPauEnCt2yY0sRgf5qAvOuKtDF3yfz+phjfTt+3sDU66nhH3YWJ70w/+wfKWkTLj9XEk3FdgQEcI49qQkk+W0CcEG169MzOWNkF1aM0tc/dT3WkpJwkdfXOfNgrdL0A8MTVHwqJHpzDLwKBgQCciw4yCWm8wM30ntD8sodV8YEBQ/mv6cjAkWoWayB/jkk7dYshpBcXykvjXo6DyprCcabXVJUTVOHE3n+6fTZvuQ4y85EK9s5MVVZH/QvuBslL5egbsBblyeThS41iIEQJDO4z3/l5QgkDc8WxIDAWHC72IecA/uAumkR4WLxmlwKBgQDLTKYqe0XfmauHFID/2Lg6R2kJ/yqPFPJp2YETGtUvq6Pqud7H5s9ztKbCFtlqQqn1JyHH/XS3tw1e4rIv74SP9iJsHop7axwzT9eFEOYAbwA+Hd9Xd2nZ0x9LkTB4OmUUeGlgqNd68AtcPskkisMcXbv9DKcCTpY4oYkYmmiMVwKBgAUdMdiGoDKvZcsRCSjIOE2hdyJwcw7BJ3LLDVkwJL6mClRr8aCmuK5pSHNkGmnJy6aAif/M3pXkFwAUeL3B625Y8FLPzDQ8fd7WhtwRMzuScy8Mkrmc1hKpttV5X2QOQ8q75mhBb+f7NUoslQ/FSmzefNZDo0VQDkjXd1crJvR/AoGBAKvYlnv16nUc72C4vIvnFMFLL7LgYVLZqWexzgqMHDfkmAiZ5iVtjqA4U8dsARaH6OG+NquyWuvkcn+WIbpMypNVdmN0y3V+Aio6Y2mSe8JzUcktubvLoZQTt8zR4w6bDWcJMrewOOb5MmfQ1TMldGk+jXwlNIhnWlKOUNi7f0Yf";
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlmAM51FDpU9hF1Oc//xAg9g6pENoR73ZfswbIVzEkg9g9+3q4XAI0zC0vmBvhohF7KY/0jggs16ZvXM5AcbteInZZp/1PA63a+U0q5AAFyHI6+NR8r9XW/4sRvfTG4l1PBl22vA9s3Go3x1wqioinpzpbnJQvtrVsNG/C60jlZZUF13kQq4RCEuycGRMCW+an6LWM6KGEfEDf+l4NMXavcPGVi5euxjVEIolFjW7bAykcuEdZYqtPpP75mPaOFmPNH110/E+piElRxxfp970o4ncLwNI0MIzxHth3/kNsZ0+l2UIZU4t2hKcXGGYUVVxTydMCk+AtdSGHYtuFE2MSwIDAQAB";

    /**
     * 生成随机UUID
     *
     * @return 随机的UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", " ");
    }

}
