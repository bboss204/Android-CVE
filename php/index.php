<?php   
    include_once('db.php');

    try {

# http://127.0.0.1/index.php?datePublished=2024-01-29&product=N200RE
        $datePublished = isset($_GET['datePublished']) ? htmlspecialchars($_GET['datePublished']) : null;
        $dateUpdated = isset($_GET['dateUpdated']) ? htmlspecialchars($_GET['dateUpdated']) : null;
        $title = isset($_GET['title']) ? htmlspecialchars($_GET['title']) : null;
        $cveID = isset($_GET['cveID']) ? htmlspecialchars($_GET['cveID']) : null;
        $vendor = isset($_GET['vendor']) ? htmlspecialchars($_GET['vendor']) : null;
        $product = isset($_GET['product']) ? htmlspecialchars($_GET['product']) : null;
        $versionProduct = isset($_GET['version_product']) ? htmlspecialchars($_GET['version_product']) : null;
        $cvss_baseScore = isset($_GET['cvss_baseScore']) ? htmlspecialchars($_GET['cvss_baseScore']) : null;


        if ($datePublished || $dateUpdated || $title || $cveID || $vendor || $product || $versionProduct || $cvss_baseScore) {
            $conn = createConnection();

            $sqlcve = "SELECT * 
            FROM cve
            WHERE (:datePublished IS NULL OR datePublished = :datePublished)
            AND (:dateUpdated IS NULL OR dateUpdated = :dateUpdated)
            AND (:title IS NULL OR title LIKE :title)
            AND (:cveID IS NULL OR cveID = :cveID)
            AND (:vendor IS NULL OR vendor = :vendor)
            AND (:product IS NULL OR product = :product)
            AND (:versionProduct IS NULL OR version_product = :versionProduct)
            AND (:cvss_baseScore IS NULL OR ABS(cvss_baseScore - :cvss_baseScore) < 0.01);

            ";
            $stmtcve = $conn->prepare($sqlcve);
            $stmtcve->bindParam(':datePublished', $datePublished);
            $stmtcve->bindParam(':dateUpdated', $dateUpdated);
            $stmtcve->bindParam(':title', $title);
            $stmtcve->bindParam(':cveID', $cveID);
            $stmtcve->bindParam(':vendor', $vendor);
            $stmtcve->bindParam(':product', $product);
            $stmtcve->bindParam(':versionProduct', $versionProduct);
            $stmtcve->bindParam(':cvss_baseScore', $cvss_baseScore);
            $stmtcve->execute();
            $cve = $stmtcve->fetchAll(PDO::FETCH_ASSOC);
        
            if (!empty($cve)) {
                $tab = array();
                echo "Nombre d'enregistrements récupérés : " . count($cve) . "<br>";
                foreach ($cve as $row) {
                    $tab[] = $row;
                }
                echo json_encode($tab); 
            } else {
                echo "Aucun résultat trouvé.";
            }
        } else {
            echo "Aucun paramètre renseigné.";
        }
    } catch(PDOException $e) {
        echo "Connection failed: " . $e->getMessage();
    }
    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);
?>