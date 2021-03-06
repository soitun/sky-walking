package com.a.eye.skywalking.reciever.processor;

import com.a.eye.skywalking.protocol.common.AbstractDataSerializable;
import com.a.eye.skywalking.reciever.util.HBaseUtil;
import org.apache.hadoop.hbase.client.Connection;

import java.util.List;

public abstract class AbstractSpanProcessor implements IProcessor{

    @Override
    public void process(List<AbstractDataSerializable> serializedObjects) {
        doAlarm(serializedObjects);
        doSaveHBase(HBaseUtil.getConnection(), serializedObjects);
    }

    public abstract void doAlarm(List<AbstractDataSerializable> serializedObjects);

    public abstract void doSaveHBase(Connection connection, List<AbstractDataSerializable> serializedObjects);

}
