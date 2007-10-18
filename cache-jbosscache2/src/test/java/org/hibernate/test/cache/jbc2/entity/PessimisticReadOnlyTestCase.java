/*
 * Copyright (c) 2007, Red Hat Middleware, LLC. All rights reserved.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, v. 2.1. This program is distributed in the
 * hope that it will be useful, but WITHOUT A WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. You should have received a
 * copy of the GNU Lesser General Public License, v.2.1 along with this
 * distribution; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * Red Hat Author(s): Brian Stansberry
 */

package org.hibernate.test.cache.jbc2.entity;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.hibernate.cache.access.AccessType;

/**
 * Tests READ_ONLY access when pessimistic locking and invalidation are used.
 * 
 * @author <a href="brian.stansberry@jboss.com">Brian Stansberry</a>
 * @version $Revision: 1 $
 */
public class PessimisticReadOnlyTestCase extends AbstractReadOnlyAccessTestCase {

    /**
     * Create a new PessimisticTransactionalAccessTestCase.
     * 
     * @param name
     */
    public PessimisticReadOnlyTestCase(String name) {
        super(name);
    }
    
    public static Test suite() throws Exception {
        TestSuite suite = createFailureExpectedSuite(PessimisticReadOnlyTestCase.class); 
        return getTestSetup(suite, "pessimistic-entity");
    }
    
    // Known failures   

    public void testEvictAllFailureExpected() {
        super.testEvictAll();
    }

    public void testRemoveAllFailureExpected() {
        super.testRemoveAll();
    }
    
    // Overrides   


    @Override
    public void testCacheConfiguration() {
        assertTrue("Using Invalidation", isUsingInvalidation());
        assertFalse("Using Optimistic locking", isUsingOptimisticLocking());
    }
    

}
