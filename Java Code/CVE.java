public class CVE {
    private int id;
    private String cveID;
    private String state;
    private String datePublished;
    private String dateUpdated;
    private String title;
    private String vendor;
    private String product;
    private String versionProduct;
    private String statusProduct;
    private String descriptions;
    private float cvssBaseScore;
    private String technicalDescription;
    private String exploit;

    // Constructeur
    public CVE(int id, String cveID, String state, String datePublished, String dateUpdated, 
               String title, String vendor, String product, String versionProduct, 
               String statusProduct, String descriptions, float cvssBaseScore, 
               String technicalDescription, String exploit) {
        this.id = id;
        this.cveID = cveID;
        this.state = state;
        this.datePublished = datePublished;
        this.dateUpdated = dateUpdated;
        this.title = title;
        this.vendor = vendor;
        this.product = product;
        this.versionProduct = versionProduct;
        this.statusProduct = statusProduct;
        this.descriptions = descriptions;
        this.cvssBaseScore = cvssBaseScore;
        this.technicalDescription = technicalDescription;
        this.exploit = exploit;
    }

    // Méthode pour générer une requête SQL INSERT
    public String toSQL() {
        return String.format(
            "INSERT INTO CVE (id, cveID, state, datePublished, dateUpdated, title, vendor, " +
            "product, version_product, status_product, descriptions, cvss_baseScore, " +
            "technical_description, exploit) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', " +
            "'%s', '%s', '%s', '%s', %.2f, '%s', '%s');",
            id, escapeSQL(cveID), escapeSQL(state), datePublished, dateUpdated,
            escapeSQL(title), escapeSQL(vendor), escapeSQL(product),
            escapeSQL(versionProduct), escapeSQL(statusProduct), escapeSQL(descriptions),
            cvssBaseScore, escapeSQL(technicalDescription), escapeSQL(exploit)
        );
    }

    // Méthode pour échapper les caractères problématiques dans une requête SQL
    private String escapeSQL(String value) {
        if (value == null) {
            return "NULL";
        }
        return value.replace("'", "''"); // Échappe les apostrophes pour éviter les erreurs SQL
    }

    // Méthode toString() pour afficher l'objet facilement
    @Override
    public String toString() {
        return String.format(
            "CVE{id=%d, cveID='%s', state='%s', datePublished='%s', dateUpdated='%s', title='%s', " +
            "vendor='%s', product='%s', versionProduct='%s', statusProduct='%s', descriptions='%s', " +
            "cvssBaseScore=%.2f, technicalDescription='%s', exploit='%s'}",
            id, cveID, state, datePublished, dateUpdated, title, vendor, product,
            versionProduct, statusProduct, descriptions, cvssBaseScore,
            technicalDescription, exploit
        );
    }
}
