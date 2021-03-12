/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import entities.enunm.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author eletr
 */
class StateValidator  implements ConstraintValidator<ValidateState, Integer>{
    private List<OrderStatus> states;    
    
    public StateValidator(){
        
    }
    
    @Override
    public void initialize(ValidateState validaEstado) {
        this.states = new ArrayList<>();
        this.states.add(OrderStatus.PAID);
        this.states.add(OrderStatus.CANCELED);
        this.states.add(OrderStatus.DELIVERED);
        this.states.add(OrderStatus.SHIPPED);
        this.states.add(OrderStatus.WAITING_PAYMENT);
    }

    @Override
    public boolean isValid(Integer valor, ConstraintValidatorContext context) {
        return valor == null ? false : states.contains(OrderStatus.valueOf(valor));
    }
}
