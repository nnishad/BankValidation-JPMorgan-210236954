package com.nikhilnishad.bankservice.model;

import java.util.List;

public class Response {
	private List<Result> result;

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public class Result {
		private String source;
		private boolean isValid;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public boolean isValid() {
			return isValid;
		}

		public void setValid(boolean isValid) {
			this.isValid = isValid;
		}

	}
}
