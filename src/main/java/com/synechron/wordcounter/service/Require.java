package com.synechron.wordcounter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

public final class Require {
        private static final Logger g_log = LoggerFactory.getLogger(Require.class);

        public static <T> T requireNonNull(@Nullable final T t, final String msg) {
            if (t == null) {
                final IllegalArgumentException ex = new IllegalArgumentException(msg);
                Require.g_log.error(ex.toString(), ex);
                throw ex;
            }
            return t;
        }

    public static int requireNonNegative(final int value, final String msg)
    {
        if (value < 0)
            throw new IllegalArgumentException(msg);
        return value;
    }

    public static float requireNonNegative(final float value, final String msg)
    {
        if (value < 0.0f)
            throw new IllegalArgumentException(msg);
        return value;
    }
}

