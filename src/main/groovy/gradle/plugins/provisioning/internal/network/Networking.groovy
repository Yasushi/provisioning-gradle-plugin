package gradle.plugins.provisioning.internal.network

/**
 * User: danielwoods
 * Date: 12/8/13
 */
class Networking {
  List<Device> devices = []

  void device(String name, @DelegatesTo(Device) Closure clos) {
    def device = new Device(name)
    clos.delegate = device
    clos.resolveStrategy = Closure.DELEGATE_FIRST
    clos.call()
    devices << device
  }
}
