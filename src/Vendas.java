import java.util.ArrayList;
import java.util.List;

public class Vendas {

	private int id;
	private String orcamento;
	private String dtVenda;
	private String dtInstalacao;
	private String vendedor;
	private String revan;
	private String cidade;
	private String cliente;
	private String cpf;
	private String plano;
	private String valor;
		
	public Vendas() {}
	
	public Vendas(int id, String orcamento, String dtVenda, String dtInstalacao, String vendedor, String revan,
			String cidade, String cliente, String cpf, String plano, String valor) {
		this.id = id;
		this.orcamento = orcamento;
		this.dtVenda = dtVenda;
		this.dtInstalacao = dtInstalacao;
		this.vendedor = vendedor;
		this.revan = revan;
		this.cidade = cidade;
		this.cliente = cliente;
		this.cpf = cpf;
		this.plano = plano;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setDtOrcamento(String dtVenda) {
		this.dtVenda = dtVenda;
	}

	public String getDtInstalacao() {
		return dtInstalacao;
	}

	public void setDtInstalacao(String dtInstalacao) {
		this.dtInstalacao = dtInstalacao;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getRevan() {
		return revan;
	}

	public void setRevan(String revan) {
		this.revan = revan;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	@Override
	public String toString() {
		return "Vendas [id=" + id + ", orcamento=" + orcamento + ", dtVenda=" + dtVenda + ", dtInstalacao="
				+ dtInstalacao + ", vendedor=" + vendedor + ", revan=" + revan + ", cidade=" + cidade + ", cliente="
				+ cliente + ", cpf=" + cpf + ", plano=" + plano + ", valor=" + valor + "]";
	}

	
}
