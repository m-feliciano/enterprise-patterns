package br.com.code.enterprise.repository;

public interface Entity<ID> {
    ID getId();

    void setId(ID id);
}
