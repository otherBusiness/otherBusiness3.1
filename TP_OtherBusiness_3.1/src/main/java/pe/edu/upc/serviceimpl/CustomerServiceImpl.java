package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.ICustomerDao;
import pe.edu.upc.entity.Customer;
import pe.edu.upc.serviceinterface.ICustomerService;

@Named
public class CustomerServiceImpl implements ICustomerService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ICustomerDao cD;

	@Transactional
	@Override
	public Integer insert(Customer t) throws Exception {
		return cD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Customer t) throws Exception {
		return cD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Customer t) throws Exception {
		return cD.delete(t);
	}

	@Override
	public List<Customer> getAll() throws Exception {
		return cD.findAll();
	}

	@Override
	public Optional<Customer> getOne(Customer t) throws Exception {
		return cD.findById(t);
	}

	@Override
	public List<Customer> findCustomerByName(String name) throws Exception {
		return cD.findByName(name);
	}

	@Override
	public Optional<Customer> findCustomerByDni(String dni) throws Exception {
		return cD.findByDni(dni);
	}
}
