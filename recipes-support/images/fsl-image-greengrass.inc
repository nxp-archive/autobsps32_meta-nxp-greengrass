#
# Copyright 2020 NXP
#

DESCRIPTION = "Greengrass Image"
LICENSE = "MIT"

IMAGE_INSTALL_append = " openjdk-8"
IMAGE_INSTALL_append = " greengrass"
IMAGE_INSTALL_append = " python"
IMAGE_INSTALL_append = " python3"
IMAGE_INSTALL_append = " bash"
IMAGE_INSTALL_append = " nodejs"
#IMAGE_INSTALL_append = " nxp-networking"
IMAGE_INSTALL_append = " os-release"
IMAGE_INSTALL_append = " ntp"
IMAGE_INSTALL_append = " python-pip"
IMAGE_INSTALL_append = " python3-pip"
IMAGE_INSTALL_append = " python3-graphviz"
IMAGE_INSTALL_append = " mxnet"
IMAGE_INSTALL_append = " tensorflow"

IMAGE_ROOTFS_EXTRA_SPACE = "2097152"

ROOTFS_POSTPROCESS_COMMAND += " \
    setup_volatiles; \
    config_ntpserver; \
"

setup_volatiles() {

if  [ -f "${IMAGE_ROOTFS}/etc/sysctl.conf" ]; then

sed -i -e '/protected/d' ${IMAGE_ROOTFS}/etc/sysctl.conf
cat >> $D${sysconfdir}/sysctl.conf <<-_EOF_
# Greengrass: protect hardlinks/symlinks
fs.protected_hardlinks = 1
fs.protected_symlinks = 1
_EOF_

fi

# Disable '/etc/resolv.conf' symlink
if [ -f "${IMAGE_ROOTFS}/etc/default/volatiles/00_core" ]; then

sed -i -e '/resolv.conf/d' ${IMAGE_ROOTFS}/etc/default/volatiles/00_core
sed -i -e '\/tmp \/var\/tmp/d' ${IMAGE_ROOTFS}/etc/default/volatiles/00_core
cat >> ${IMAGE_ROOTFS}/etc/default/volatiles/00_core <<-_EOF_
# Greengrass: create a real (no symlink) resolv.conf
f root root 0644 /etc/resolv.conf none
d root root 1777 /tmp none
_EOF_

fi


if  [ -f "${IMAGE_ROOTFS}/etc/init.d/cgroups-init" ]; then

sed -i '/bin\/cgroups-mount/a echo\ \1 \>\/sys\/fs\/cgroup\/memory.use_hierarchy' ${IMAGE_ROOTFS}/etc/init.d/cgroups-init

fi

}

config_ntpserver() {

if [ -f "${IMAGE_ROOTFS}/etc/ntp.conf" ]; then

sed -i -e '/server/d' ${IMAGE_ROOTFS}/etc/ntp.conf
cat ${IMAGE_ROOTFS}/etc/ntp.conf
cat >> ${IMAGE_ROOTFS}/etc/ntp.conf <<-_EOF_
server pool.ntp.org
_EOF_

fi

}
