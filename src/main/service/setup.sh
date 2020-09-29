#!/usr/bin/env bash
systemctl stop erp
adduser --user-group erpUser
usermod -s /sbin/nologin erpUser
mkdir -p /var/lib/erp
mkdir -p /var/log/erp
chmod +500 *.war
chmod +x *.war
chattr +i *.war
cp *.war /var/lib/erp/erp.war
cp erp.service /etc/systemd/system
chown erpUser:erpUser -R /var/lib/erp
chown erpUser:erpUser -R /var/log/erp
systemctl  enable erp.service
systemctl daemon-reload
chattr -i *.war
systemctl start erp.service
tail -f /var/log/erp/erp.log


