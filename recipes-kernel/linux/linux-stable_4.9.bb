require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "overo"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap3-overo-storm-tobi.dtb \
    omap3-overo-tobi.dtb \
 "

LINUX_VERSION = "4.9"
LINUX_VERSION_EXTENSION = "-lbl"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.9:"

S = "${WORKDIR}/git"

PR = "r2"

PV = "4.9.20"
SRCREV = "f6767727467056943bf6d3433ffce0a8b2b05681"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y \
    file://defconfig \
 "
