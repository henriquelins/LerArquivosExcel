public class NaoInstalados {

	private Integer id;
	private String orcamento;
	private String dtVenda;
	private String vendedor;
	private String cliente;
	private String cpf;
	private String plano;
	private String valor;
		
	public NaoInstalados() {}

	public NaoInstalados(Integer id, String orcamento, String dtVenda, String vendedor, String cliente, String cpf,
			String plano, String valor) {
		this.id = id;
		this.orcamento = orcamento;
		this.dtVenda = dtVenda;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.cpf = cpf;
		this.plano = plano;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}

	public String getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(String dtVenda) {
		this.dtVenda = dtVenda;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	

	
}
