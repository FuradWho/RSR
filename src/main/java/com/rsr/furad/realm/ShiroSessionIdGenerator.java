package com.rsr.furad.realm;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * @author 13375
 */
public class ShiroSessionIdGenerator implements SessionIdGenerator {
    /**
     * 实现SessionId生成
     *
     * @param session
     * @return
     */
    @Override
    public Serializable generateId(Session session) {
        Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", sessionId);
    }

}
