
pkg_postinst_ontarget_${PN}() {
    # Enable protection for hardlinks and symlinks
    if ! grep -qs 'protected_.*links' $D${sysconfdir}/sysctl.conf | grep -v '^#'; then
    cat >> $D${sysconfdir}/sysctl.conf <<-_EOF_
# Greengrass: protect hardlinks/symlinks
fs.protected_hardlinks = 1
fs.protected_symlinks = 1
_EOF_
    fi

        # Disable '/etc/resolv.conf' symlink
        if [ -f "$D${sysconfdir}/default/volatiles/00_core" ]; then
                sed -i -e '/resolv.conf/d' $D${sysconfdir}/default/volatiles/00_core
                cat >> $D${sysconfdir}/default/volatiles/00_core <<-_EOF_
                        # Greengrass: create a real (no symlink) resolv.conf
                        f root root 0644 /etc/resolv.conf none
                _EOF_
        fi
}

