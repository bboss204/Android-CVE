<?php   
    include_once('../outils/bd.php');

    try {

# http://127.0.0.1/saedev/index.php?datePublished=2024-01-29
        $datePublished = isset($_GET['datePublished']) ? htmlspecialchars($_GET['datePublished']) : null;
        $dateUpdated = isset($_GET['dateUpdated']) ? htmlspecialchars($_GET['dateUpdated']) : null;
        $title = isset($_GET['title']) ? htmlspecialchars($_GET['title']) : null;
        $cveID = isset($_GET['cveID']) ? htmlspecialchars($_GET['cveID']) : null;
        $vendor = isset($_GET['vendor']) ? htmlspecialchars($_GET['vendor']) : null;
        $product = isset($_GET['product']) ? htmlspecialchars($_GET['product']) : null;
        $versionProduct = isset($_GET['version_product']) ? htmlspecialchars($_GET['version_product']) : null;

        $conn = createConnection();

        $sqlcve = "SELECT * 
                    FROM cve
                    WHERE datePublished = :datePublished
                    AND dateUpdated = :dateUpdated
                    AND title LIKE :title
                    AND cveID = :cveID
                    AND vendor = :vendor
                    AND product = :product
                    AND version_product = :versionProduct;
                    ";
        $stmtcve = $conn->prepare($sqlcve);
        $stmtcve->bindParam(':datePublished', $datePublished);
        $stmtcve->bindParam(':dateUpdated', $dateUpdated);
        $stmtcve->bindParam(':title', $title);
        $stmtcve->bindParam(':cveID', $cveID);
        $stmtcve->bindParam(':vendor', $vendor);
        $stmtcve->bindParam(':product', $product);
        $stmtcve->bindParam(':versionProduct', $versionProduct);
        $stmtcve->execute();
        $cve = $stmtcve->fetchAll();
       
        if (!empty($results)) {
            echo "<h3>Résultats :</h3><ul>";
            foreach ($results as $row) {
                echo "<li>" . htmlspecialchars(print_r($row, true)) . "</li>";
            }
            echo "</ul>";
        } else {
            echo "Aucun résultat trouvé.";
        }
    } catch(PDOException $e) {
        echo "Connection failed: " . $e->getMessage();
    }
    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);
?>