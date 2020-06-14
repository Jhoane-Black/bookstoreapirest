package com.yorch.springboot.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int cli_id;
	private String cli_nom;
	private String cli_ape;
	private String cli_pais;
	private String cli_email;
	private String cli_pass;
	private String cli_cc;
	private String cli_ccday;
	private String cli_ccmonth;
	private String cli_ccyear;
	@Enumerated(EnumType.STRING)
	private ClientRole cli_role;


	public Client() {
		super();
	}

	public Client(String cli_nom, String cli_ape, String cli_pais, String cli_email, String cli_pass, String cli_cc, String cli_ccday, String cli_ccmonth, String cli_ccyear) {
		this.cli_nom = cli_nom;
		this.cli_ape = cli_ape;
		this.cli_pais = cli_pais;
		this.cli_email = cli_email;
		this.cli_pass = cli_pass;
		this.cli_cc = cli_cc;
		this.cli_ccday = cli_ccday;
		this.cli_ccmonth = cli_ccmonth;
		this.cli_ccyear = cli_ccyear;
	}

	public int getCli_id() {
		return cli_id;
	}

	public String getCli_nom() {
		return cli_nom;
	}

	public void setCli_nom(String cli_nom) {
		this.cli_nom = cli_nom;
	}

	public String getCli_ape() {
		return cli_ape;
	}

	public void setCli_ape(String cli_ape) {
		this.cli_ape = cli_ape;
	}

	public String getCli_pais() {
		return cli_pais;
	}

	public void setCli_pais(String cli_pais) {
		this.cli_pais = cli_pais;
	}

	public String getCli_email() {
		return cli_email;
	}

	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}

	public String getCli_pass() {
		return cli_pass;
	}

	public void setCli_pass(String cli_pass) {
		this.cli_pass = cli_pass;
	}

	public String getCli_cc() {
		return cli_cc;
	}

	public void setCli_cc(String cli_cc) {
		this.cli_cc = cli_cc;
	}

	public String getCli_ccday() {
		return cli_ccday;
	}

	public void setCli_ccday(String cli_ccday) {
		this.cli_ccday = cli_ccday;
	}

	public String getCli_ccmonth() {
		return cli_ccmonth;
	}

	public void setCli_ccmonth(String cli_ccmonth) {
		this.cli_ccmonth = cli_ccmonth;
	}

	public String getCli_ccyear() {
		return cli_ccyear;
	}

	public void setCli_ccyear(String cli_ccyear) {
		this.cli_ccyear = cli_ccyear;
	}

	public ClientRole getCli_role() {
		return cli_role;
	}

	public void setCli_role(ClientRole cli_role) {
		this.cli_role = cli_role;
	}
}
