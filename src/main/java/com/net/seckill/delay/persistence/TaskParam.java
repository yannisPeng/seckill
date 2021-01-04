package com.net.seckill.delay.persistence;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 参数
 *
 * @author 10014994
 * @since 2020/11/15
 */
@Data
public class TaskParam {

    private Map<String, Object> customizeCache = new HashMap<>();

    private String taskTag;

    public TaskParam() {
    }

    public static TaskParamBuilder builder() {
        return new TaskParamBuilder();
    }

    public static final class TaskParamBuilder {

        Map<String, Object> customizeCache = new HashMap<>();

        private String taskTag;

        public TaskParamBuilder addParam(String key, Object value) {
            customizeCache.put(key, value);
            return this;
        }

        public TaskParamBuilder setTaskTag(String msg){
            this.taskTag = msg;
            return this;
        }

        public TaskParam build() {
            TaskParam taskParam = new TaskParam();
            taskParam.customizeCache = this.customizeCache;
            taskParam.taskTag = this.taskTag;
            return taskParam;
        }
    }

}
