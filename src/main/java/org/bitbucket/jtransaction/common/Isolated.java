package org.bitbucket.jtransaction.common;


/**
 * Isolated
 * 
 * @author afs
 * @version 2013
*/

public interface Isolated {
    /** Returns the implemented Isolation level on this object.
     */
    IsolationLevel getIsolationLevel();
}