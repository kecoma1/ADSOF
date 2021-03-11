package prac2.traffic;

public enum PollutionIndex {
	A, B, C;
	
	private static final int DATEA = 2018;
	private static final int DATEB = 2010;
	
	public static PollutionIndex getPollutionIndex(int year) {
		if (year >= DATEA) return A;
		if (year >= DATEB) return B;
		return C;
	}
}
