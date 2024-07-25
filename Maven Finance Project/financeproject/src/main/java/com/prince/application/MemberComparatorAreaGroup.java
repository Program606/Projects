package com.prince.application;

import java.util.Comparator;

public class MemberComparatorAreaGroup implements Comparator<Member>{

    @Override
    public int compare(Member m1, Member m2) {
        int result = m1.getAreaGroup().compareTo(m2.getAreaGroup());
        if(result == 0){
            result = m1.getLastName().compareTo(m2.getLastName());
            if(result == 0){
                result = m1.getFirstName().compareTo(m2.getFirstName());
            }
        }
        return result;
    }

}
