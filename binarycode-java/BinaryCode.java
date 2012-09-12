public class BinaryCode {

	public String[] decode(String message) {
		System.out.println(message);
		String ret[] = { decodeMessage(message, 0), decodeMessage(message, 1) };

		return ret;
	}

	private String decodeMessage(String message, int first) {

		char q[] = message.toCharArray();
		int p[] = new int[q.length];
		p[0] = first;

		if (q.length == 1) {
			if (q[0] - 48 > 1) {
				return "NONE";
			}
		} else {
			for (int i = 0; i < q.length - 1; i++) {
				if (i == 0) {
					int t = q[0] - p[0] - 48;
					if (t > 1) {
						return "NONE";
					}
					p[i + 1] = t;

				} else {
					int t = q[i] - p[i - 1] - p[i] - 48;
					if (t > 1) {
						return "NONE";
					}
					p[i + 1] = t;
				}
			}
		}

		if (q[q.length - 1] - 48 != p[q.length - 1] + p[q.length - 2]) {
			return "NONE";
		}

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < p.length; i++) {
			buf.append(p[i]);
		}

		return buf.toString();

	}

}
