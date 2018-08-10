package testdatatypes;

public class Customer {

	public String Username;
	public String password;
	public NewsletterDetails NewsletterDetails;
	

	public class NewsletterDetails {

		public String Newslettername;
		public String Sendername;
		public String SubjectLine;
		public String category;
		public String subcategory;
		public String customername;
		public String clientname;
		public String Hostingserver;
		public String opensms;
		public String clicksms;
		
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("NewsletterDetails [Newslettername=");
			builder.append(Newslettername);
			builder.append(", Sendername=");
			builder.append(Sendername);
			builder.append(", SubjectLine=");
			builder.append(SubjectLine);
			builder.append(", category=");
			builder.append(category);
			builder.append(", subcategory=");
			builder.append(subcategory);
			builder.append(", customername=");
			builder.append(customername);
			builder.append(", clientname=");
			builder.append(clientname);
			builder.append(", Hostingserver=");
			builder.append(Hostingserver);
			builder.append(", opensms=");
			builder.append(opensms);
			builder.append(", clicksms=");
			builder.append(clicksms);
			builder.append("]");
			return builder.toString();
		}
		
		
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [Username=");
		builder.append(Username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", NewsletterDetails=");
		builder.append(NewsletterDetails);
		builder.append("]");
		return builder.toString();
	}

}
