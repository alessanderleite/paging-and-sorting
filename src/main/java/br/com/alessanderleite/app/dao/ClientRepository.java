package br.com.alessanderleite.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.app.model.ClientModel;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientModel, Long> {

}
