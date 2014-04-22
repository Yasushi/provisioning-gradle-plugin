package gradle.plugins.provisioning.internal.firewall

class Firewall {
  Boolean disabled = false
  List<String> trustDevices = []
  Boolean ssh = true
  Boolean telnet = false
  Boolean smtp = false
  Boolean http = false
  Boolean ftp = false
  List<String> ports = []
}