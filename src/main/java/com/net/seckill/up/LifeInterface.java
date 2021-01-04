package com.net.seckill.up;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/12
 */
public interface LifeInterface extends SuperBeing{

    static Builder build(String name) {
        return new Builder(name);
    }

    class Builder {

        private String name;

        public Builder(String name) {
            System.out.println(name);
            this.name = name;
        }

        public void goSchool(Action action){
            System.out.println("去学校");
            action.payMoney(new Dollar());
        }

        public void buyDish(Action action){
            System.out.println("去买菜");
            action.payMoney(new Renminbi());
        }
    }
}
