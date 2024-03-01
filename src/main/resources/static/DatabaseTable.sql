CREATE TABLE energy_tab (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dtm DATETIME NOT NULL,
    MIP DECIMAL(10, 2),
    Solar_MW DECIMAL(10, 2),
    Solar_capacity_mwp DECIMAL(10, 2),
    Solar_installedcapacity_mwp DECIMAL(10, 2),
    Wind_MW DECIMAL(10, 2),
    SS_Price DECIMAL(10, 2),
    boa_MWh DECIMAL(10, 2),
    DA_Price DECIMAL(10, 2)
);
