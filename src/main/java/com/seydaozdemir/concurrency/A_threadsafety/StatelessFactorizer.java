package com.seydaozdemir.concurrency.A_threadsafety;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class StatelessFactorizer implements Servlet {
    /**
     *  While the increment operation, ++count, may look like
     *  a single action because of its compact syntax, it is not atomic,
     *  which means that it does not execute as a single, indivisible operation.
     *  Instead, it is a shorthand for a sequence of three discrete operations:
     *  fetch the current value, add one to it, and write the new value back.
     *  This is an example of a read-modify-write operation,
     *  in which the resulting state is derived from the previous state.
     */
    private int count;
    /**
     * Where practical, use existing thread-safe objects, like AtomicLong,
     * to manage your class's state. It is simpler to reason about the possible
     * states and state transitions for existing thread-safe objects than it is
     * for arbitrary state variables,
     * and this makes it easier to maintain and verify thread safety.
     */

    private AtomicInteger threadSafeCount;



    /**
     * StatelessFactorizer is, like most servlets,
     * stateless: it has no fields and references
     * no fields from other classes.
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {
        /**
         * The transient state for a particular computation exists solely in local
         * variables that are stored on the
         * thread's stack and are accessible only to the executing thread.
         */
        BigInteger i=extractFromRequest(servletRequest);
        count++;
        threadSafeCount.incrementAndGet();

    }

    private BigInteger extractFromRequest(ServletRequest servletRequest) {
        return BigInteger.ONE;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
