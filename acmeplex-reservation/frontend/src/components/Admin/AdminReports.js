import React, { useEffect, useState } from "react";
import axios from "axios";

const Reports = () => {
    const [sales, setSales] = useState([]);
    const [cancellations, setCancellations] = useState([]);

    useEffect(() => {
        const fetchReports = async () => {
            const salesResponse = await axios.get("http://localhost:8080/api/admin/reports/sales");
            const cancellationResponse = await axios.get("http://localhost:8080/api/admin/reports/cancellations");
            setSales(salesResponse.data);
            setCancellations(cancellationResponse.data);
        };
        fetchReports();
    }, []);

    return (
        <div>
            <h3>Sales Report</h3>
            <ul>
                {sales.map((report, index) => (
                    <li key={index}>
                        {report[0]} - Tickets Sold: {report[1]}, Revenue: ${report[2]}
                    </li>
                ))}
            </ul>
            <h3>Cancellation Report</h3>
            <ul>
                {cancellations.map((report, index) => (
                    <li key={index}>
                        {report[0]} - Tickets Cancelled: {report[1]}, Refunds Issued: ${report[2]}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Reports;
