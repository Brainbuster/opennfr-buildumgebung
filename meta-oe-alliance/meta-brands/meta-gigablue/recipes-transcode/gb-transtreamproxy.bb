SUMMARY = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

PROVIDES += "virtual/transtreamproxy"
RPROVIDES_${PN} += "virtual/transtreamproxy"

SRC_URI = "git://github.com/openmips/gb-transtreamproxy.git;protocol=git"

inherit autotools

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/bin
    install -m 0755 ${WORKDIR}/build/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}

pkg_prerm_${PN}() {
#!/bin/sh
grep -vE '^#*\s*8002' $D/etc/inetd.conf > $D/tmp/inetd.tmp
mv $D/tmp/inetd.tmp $D/etc/inetd.conf

if [ -z "$D" -a -f "/etc/init.d/inetd.busybox" ]; then
	/etc/init.d/inetd.busybox restart
fi
}

pkg_preinst_${PN}() {
#!/bin/sh
grep -vE '^#*\s*8002' $D/etc/inetd.conf > $D/tmp/inetd.tmp
mv $D/tmp/inetd.tmp $D/etc/inetd.conf

if [ -z "$D" -a -f "/etc/init.d/inetd.busybox" ]; then
	/etc/init.d/inetd.busybox restart
fi
}

pkg_postinst_${PN}() {
#!/bin/sh
if ! grep -qE '^#*\s*8002' $D/etc/inetd.conf; then
	if grep -qE "^#*\s*8003" $D/etc/inetd.conf; then
		sed -i "s#^\(\#*\s*8003\)#8002\t\tstream\ttcp6\tnowait\troot\t/usr/bin/transtreamproxy\ttranstreamproxy\n\1#" $D/etc/inetd.conf
	else
	        echo -e "8002\t\tstream\ttcp6\tnowait\troot\t/usr/bin/transtreamproxy\ttranstreamproxy" >> $D/etc/inetd.conf
	fi
	if [ -z "$D" -a -f "/etc/init.d/inetd.busybox" ]; then
		/etc/init.d/inetd.busybox restart
	fi
fi
}