/* Auto-generated by genmsg_cpp for file /home/accompany/git/accompany/accompany_uva_msg/msg/HumanLocationsParticles.msg */
#ifndef ACCOMPANY_UVA_MSG_MESSAGE_HUMANLOCATIONSPARTICLES_H
#define ACCOMPANY_UVA_MSG_MESSAGE_HUMANLOCATIONSPARTICLES_H
#include <string>
#include <vector>
#include <map>
#include <ostream>
#include "ros/serialization.h"
#include "ros/builtin_message_traits.h"
#include "ros/message_operations.h"
#include "ros/time.h"

#include "ros/macros.h"

#include "ros/assert.h"

#include "accompany_uva_msg/HumanLocationsParticle.h"

namespace accompany_uva_msg
{
template <class ContainerAllocator>
struct HumanLocationsParticles_ {
  typedef HumanLocationsParticles_<ContainerAllocator> Type;

  HumanLocationsParticles_()
  : particles()
  {
  }

  HumanLocationsParticles_(const ContainerAllocator& _alloc)
  : particles(_alloc)
  {
  }

  typedef std::vector< ::accompany_uva_msg::HumanLocationsParticle_<ContainerAllocator> , typename ContainerAllocator::template rebind< ::accompany_uva_msg::HumanLocationsParticle_<ContainerAllocator> >::other >  _particles_type;
  std::vector< ::accompany_uva_msg::HumanLocationsParticle_<ContainerAllocator> , typename ContainerAllocator::template rebind< ::accompany_uva_msg::HumanLocationsParticle_<ContainerAllocator> >::other >  particles;


  typedef boost::shared_ptr< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> > Ptr;
  typedef boost::shared_ptr< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator>  const> ConstPtr;
  boost::shared_ptr<std::map<std::string, std::string> > __connection_header;
}; // struct HumanLocationsParticles
typedef  ::accompany_uva_msg::HumanLocationsParticles_<std::allocator<void> > HumanLocationsParticles;

typedef boost::shared_ptr< ::accompany_uva_msg::HumanLocationsParticles> HumanLocationsParticlesPtr;
typedef boost::shared_ptr< ::accompany_uva_msg::HumanLocationsParticles const> HumanLocationsParticlesConstPtr;


template<typename ContainerAllocator>
std::ostream& operator<<(std::ostream& s, const  ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> & v)
{
  ros::message_operations::Printer< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> >::stream(s, "", v);
  return s;}

} // namespace accompany_uva_msg

namespace ros
{
namespace message_traits
{
template<class ContainerAllocator> struct IsMessage< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> > : public TrueType {};
template<class ContainerAllocator> struct IsMessage< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator>  const> : public TrueType {};
template<class ContainerAllocator>
struct MD5Sum< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> > {
  static const char* value() 
  {
    return "6e27cbdc9a5378b383474fed9b399ba3";
  }

  static const char* value(const  ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> &) { return value(); } 
  static const uint64_t static_value1 = 0x6e27cbdc9a5378b3ULL;
  static const uint64_t static_value2 = 0x83474fed9b399ba3ULL;
};

template<class ContainerAllocator>
struct DataType< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> > {
  static const char* value() 
  {
    return "accompany_uva_msg/HumanLocationsParticles";
  }

  static const char* value(const  ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> &) { return value(); } 
};

template<class ContainerAllocator>
struct Definition< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> > {
  static const char* value() 
  {
    return "accompany_uva_msg/HumanLocationsParticle[] particles\n\
\n\
================================================================================\n\
MSG: accompany_uva_msg/HumanLocationsParticle\n\
geometry_msgs/PointStamped[] locations\n\
float32 weight\n\
\n\
================================================================================\n\
MSG: geometry_msgs/PointStamped\n\
# This represents a Point with reference coordinate frame and timestamp\n\
Header header\n\
Point point\n\
\n\
================================================================================\n\
MSG: std_msgs/Header\n\
# Standard metadata for higher-level stamped data types.\n\
# This is generally used to communicate timestamped data \n\
# in a particular coordinate frame.\n\
# \n\
# sequence ID: consecutively increasing ID \n\
uint32 seq\n\
#Two-integer timestamp that is expressed as:\n\
# * stamp.secs: seconds (stamp_secs) since epoch\n\
# * stamp.nsecs: nanoseconds since stamp_secs\n\
# time-handling sugar is provided by the client library\n\
time stamp\n\
#Frame this data is associated with\n\
# 0: no frame\n\
# 1: global frame\n\
string frame_id\n\
\n\
================================================================================\n\
MSG: geometry_msgs/Point\n\
# This contains the position of a point in free space\n\
float64 x\n\
float64 y\n\
float64 z\n\
\n\
";
  }

  static const char* value(const  ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> &) { return value(); } 
};

} // namespace message_traits
} // namespace ros

namespace ros
{
namespace serialization
{

template<class ContainerAllocator> struct Serializer< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> >
{
  template<typename Stream, typename T> inline static void allInOne(Stream& stream, T m)
  {
    stream.next(m.particles);
  }

  ROS_DECLARE_ALLINONE_SERIALIZER;
}; // struct HumanLocationsParticles_
} // namespace serialization
} // namespace ros

namespace ros
{
namespace message_operations
{

template<class ContainerAllocator>
struct Printer< ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> >
{
  template<typename Stream> static void stream(Stream& s, const std::string& indent, const  ::accompany_uva_msg::HumanLocationsParticles_<ContainerAllocator> & v) 
  {
    s << indent << "particles[]" << std::endl;
    for (size_t i = 0; i < v.particles.size(); ++i)
    {
      s << indent << "  particles[" << i << "]: ";
      s << std::endl;
      s << indent;
      Printer< ::accompany_uva_msg::HumanLocationsParticle_<ContainerAllocator> >::stream(s, indent + "    ", v.particles[i]);
    }
  }
};


} // namespace message_operations
} // namespace ros

#endif // ACCOMPANY_UVA_MSG_MESSAGE_HUMANLOCATIONSPARTICLES_H

