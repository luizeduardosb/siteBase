package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {

	public String nome;
	public String email;
	public String senha;
	
	@Temporal(TemporalType.DATE)
	public Date nascimento;
	
	@Transient
	public Integer idade;

	public Integer getIdade() {
		Date currentDate = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int d1 = Integer.parseInt(formatter.format(nascimento));
		int d2 = Integer.parseInt(formatter.format(currentDate));
		int age = (d2 - d1) / 10000;
		return age;
	}
	
	@Override
	public String toString() {
		return nome + " " + email;
	}
}