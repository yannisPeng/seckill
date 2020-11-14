package com.netease.loadBalancing;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/14
 */
public interface StrategyExecutor {

    static Strategist build(String name){
        return new Strategist(name);
    }

    class Strategist{
        private String name;

        public Strategist(String name) {
            this.name = name;
        }

        public void execute(Strategy strategy){
            strategy.doStrategy();
        }
    }

}
