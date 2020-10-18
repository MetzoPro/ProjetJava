package td3;

public class Multiplication extends OperationBinaire {

	public Multiplication(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	protected ConstRationnelle simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(droite.getEntier() * gauche.getNumerateur(), gauche.getDenominateur());
	}

	protected ConstRationnelle simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur());
	}

	protected ConstEntiere simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() * droite.getEntier());
	}

	@Override
	public double calculer() {
		return this.eaLeft.calculer() * this.eaRight.calculer();
	}

	@Override
	protected ConstRationnelle simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return this.simplifie(droite, gauche);
	}

}
