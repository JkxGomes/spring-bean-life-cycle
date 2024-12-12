package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Item(String name) {
        this.name = name;
        System.out.println("1. Instantiation: Item '" + name + "' has been created.");
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("2. BeanNameAware: Bean name is set to '" + name + "'.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("4. ApplicationContextAware: ApplicationContext has been set for '" + getName() + "'.");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: BeanFactory has been set for '" + getName() + "'.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. InitializingBean: '" + getName() + "' is initialized and ready to use.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: '" + getName() + "' is being destroyed.");
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Preparing item '" + getName() + "' for use.");
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: Cleaning up resources for '" + getName() + "'.");
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: Preparing item '" + getName() + "' for action.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: Finalizing item '" + getName() + "' before destruction.");
    }
}
