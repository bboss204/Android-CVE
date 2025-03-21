<?php
    function createConnection() {
        include_once('config.php');
        try {
            $servername = $bdd["servername"];
            $username = $bdd["username"];
            $password = $bdd["password"];
            $dbname = $bdd["dbname"];

            $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch(PDOException $e) {
            echo "Connection failed: " . $e->getMessage();
        }  

        return $conn;
    }