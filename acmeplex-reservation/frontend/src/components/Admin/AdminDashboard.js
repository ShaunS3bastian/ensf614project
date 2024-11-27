import React from 'react';
import './admin.css';

const AdminDashboard = () => {
    return (
        <div className="admin-dashboard">
            <h1>Admin Dashboard</h1>
            <ul>
                <li><a href="/admin/users">Manage Users</a></li>
                <li><a href="/admin/reports">View Reports</a></li>
            </ul>
        </div>
    );
};

export default AdminDashboard;
