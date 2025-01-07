<?php

    function getCVE($param) {
        // Assuming $conn is your database connection
        global $conn;

        // Sanitize the input parameter to prevent SQL injection
        $param = mysqli_real_escape_string($conn, $param);

        // Determine if the parameter is a CVE number, OS name, or software version
        if (preg_match('/^CVE-\d{4}-\d{4,7}$/', $param)) {
            // It's a CVE number
            $query = "SELECT * FROM cve_table WHERE cve_number = '$param'";
        } elseif (preg_match('/^[a-zA-Z0-9\s]+$/', $param)) {
            // It's either an OS name or software version
            $query = "SELECT * FROM cve_table WHERE os_name = '$param' OR software_version = '$param'";
        } else {
            return "Invalid parameter format.";
        }

        $result = mysqli_query($conn, $query);

        if (mysqli_num_rows($result) > 0) {
            $cveData = mysqli_fetch_all($result, MYSQLI_ASSOC);
            return json_encode($cveData);
        } else {
            return "No CVE found for the given parameter.";
        }
    }

    // Example usage
    if (isset($_GET['param'])) {
        echo getCVE($_GET['param']);
    }

?>