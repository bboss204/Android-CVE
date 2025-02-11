public class CVE {
    public CVE (String cveID, String state, String datePublished, String dateUpdated, String title, String vendor, String product, String version_product, String status_product, String descriptions, float cvss_baseScore, String technical_description, String exploit) {
        this.cveID = cveID;
        this.state = state;
        this.datePublished = datePublished;
        this.dateUpdated = dateUpdated;
        this.title = title;
        this.vendor = vendor;
        this.product = product;
        this.version_product = version_product;
        this.status_product = status_product;
        this.descriptions = descriptions;
        this.cvss_baseScore = cvss_baseScore;
        this.technical_description = technical_description;
        this.exploit = exploit;
    }
    

}
