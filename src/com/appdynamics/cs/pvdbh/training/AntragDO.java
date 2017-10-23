package com.appdynamics.cs.pvdbh.training;

public class AntragDO {

		private int antragNummer;
		private int haendlerNummer;
		
		public AntragDO(int antragNummer, int haendlerNummer) {
			this.antragNummer = antragNummer;
			this.haendlerNummer = haendlerNummer;
		}
		
		public AntragDO getAntrag() {
			return this;
		}
		
		public int getHaendlernummer() {
			return this.haendlerNummer;
		}
		
		
}
