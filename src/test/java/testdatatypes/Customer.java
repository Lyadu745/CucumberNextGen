package testdatatypes;

public class Customer {

	public String Username;
	public String password;
	public NewsletterDetails NewsletterDetails;
	public CampaignDetails CampaignDetails;

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

	public class CampaignDetails {

		public String Campaignname;
		public String NewsletterName;
		public String SegmentName;
		public String Domain;
		public String DomainName;
		public String CampaignType;
		public String Campaigntag;
		public String MaxVolumeCap;
		public String ScheduleRTos;
		
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CampaignDetails [Campaignname=");
			builder.append(Campaignname);
			builder.append(", NewsletterName=");
			builder.append(NewsletterName);
			builder.append(", SegmentName=");
			builder.append(SegmentName);
			builder.append(", Domain=");
			builder.append(Domain);
			builder.append(", DomainName=");
			builder.append(DomainName);
			builder.append(", CampaignType=");
			builder.append(CampaignType);
			builder.append(", Campaigntag=");
			builder.append(Campaigntag);
			builder.append(", MaxVolumeCap=");
			builder.append(MaxVolumeCap);
			builder.append(", ScheduleRTos=");
			builder.append(ScheduleRTos);
			builder.append("]");
			return builder.toString();
		}

	}

}
