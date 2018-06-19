package com.yinghuo.dal.entity;


/**
 * The table STUDENT
 */
public class StudentDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * age 年龄.
     */
    private Long age;
    /**
     * card 身份证.
     */
    private Long card;
    /**
     * name 名称.
     */
    private String name;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set age 年龄.
     */
    public void setAge(Long age){
        this.age = age;
    }

    /**
     * Get age 年龄.
     *
     * @return the string
     */
    public Long getAge(){
        return age;
    }

    /**
     * Set card 身份证.
     */
    public void setCard(Long card){
        this.card = card;
    }

    /**
     * Get card 身份证.
     *
     * @return the string
     */
    public Long getCard(){
        return card;
    }

    /**
     * Set name 名称.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 名称.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }
}
