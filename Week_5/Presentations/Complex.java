public class Complex implements Comparable {
	private double re, im;
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double norm() {
		return Math.sqrt(Math.pow(re, 2) + 
				Math.pow(im, 2));
	}

	@Override
	public int compareTo(Object other) {
		if (!(other instanceof Complex))
			return 1; // Should really be ERROR.
		double myNorm = norm();
		Complex o = (Complex)other;
		double otherNorm = o.norm();
		return myNorm == otherNorm ? 0 :
			myNorm > otherNorm ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return String.format("%.1f + %.1fi", re, im);
	}
}
