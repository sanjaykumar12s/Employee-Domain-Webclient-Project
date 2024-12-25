package com.UST.Domains.dto;

import java.util.List;

public class Responsedto {
    private Domainsdto domainsdto;
    private List<Employeedto> employees;

    

    public Domainsdto getDomainsdto() {
        return domainsdto;
    }



    public void setDomainsdto(Domainsdto domainsdto) {
        this.domainsdto = domainsdto;
    }



    public List<Employeedto> getEmployees() {
        return employees;
    }



    public void setEmployees(List<Employeedto> employees) {
        this.employees = employees;
    }
    



    public Responsedto(Domainsdto domainsdto, List<Employeedto> employees) {
        this.domainsdto = domainsdto;
        this.employees = employees;
    }
    



    public Responsedto() {
    }



    @Override
    public String toString() {
        return "Responsedto [domainsdto=" + domainsdto + ", employees=" + employees + "]";
    }
}
