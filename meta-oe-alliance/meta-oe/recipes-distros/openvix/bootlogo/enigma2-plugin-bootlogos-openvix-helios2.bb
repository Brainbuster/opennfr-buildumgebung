SUMMARY = "openViX bootlogo Helios pack2"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit allarch

PV = "1.0"
PR = "r4"

SRC_URI = "http://openvix.co.uk/feeds_extras/bootlogos/openvix-helios2.zip"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/enigma2
    install -m 0644 bootlogo.mvi ${D}/etc/enigma2/bootlogo.mvi
    install -m 0644 backdrop.mvi ${D}/etc/enigma2/backdrop.mvi
    install -m 0644 radio.mvi ${D}/etc/enigma2/radio.mvi
}

SRC_URI[md5sum] = "5a8d2b3bc06770a5820ca1858086c2be"
SRC_URI[sha256sum] = "cc654ea13f7873f2e06aedfd859c42c00f466618e6279c7343c3c3a73232d3b9"

FILES_${PN} = "/etc"