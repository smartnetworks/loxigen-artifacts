/* Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University */
/* Copyright (c) 2011, 2012 Open Networking Foundation */
/* Copyright (c) 2012, 2013 Big Switch Networks, Inc. */
/* See the file LICENSE.loci which should have been included in the source distribution */

/****************************************************************
 *
 * Functions related to mapping wire values to object types
 * and lengths
 *
 ****************************************************************/

#include <loci/loci.h>
#include <loci/of_message.h>


/**
 * An array with the number of bytes in the fixed length part
 * of each OF object
 */

static const int
of_object_fixed_len_v1[OF_OBJECT_COUNT] = {
    -1,   /* of_object is not instantiable */
    36,   /* 1: of_aggregate_stats_reply */
    56,   /* 2: of_aggregate_stats_request */
    -1,   /* 3: of_async_config_failed_error_msg */
    -1,   /* 4: of_async_get_reply */
    -1,   /* 5: of_async_get_request */
    -1,   /* 6: of_async_set */
    12,   /* 7: of_bad_action_error_msg */
    -1,   /* 8: of_bad_instruction_error_msg */
    -1,   /* 9: of_bad_match_error_msg */
    -1,   /* 10: of_bad_property_error_msg */
    12,   /* 11: of_bad_request_error_msg */
    8,    /* 12: of_barrier_reply */
    8,    /* 13: of_barrier_request */
    -1,   /* 14: of_bsn_arp_idle */
    -1,   /* 15: of_bsn_base_error */
    20,   /* 16: of_bsn_bw_clear_data_reply */
    16,   /* 17: of_bsn_bw_clear_data_request */
    20,   /* 18: of_bsn_bw_enable_get_reply */
    16,   /* 19: of_bsn_bw_enable_get_request */
    24,   /* 20: of_bsn_bw_enable_set_reply */
    20,   /* 21: of_bsn_bw_enable_set_request */
    -1,   /* 22: of_bsn_controller_connections_reply */
    -1,   /* 23: of_bsn_controller_connections_request */
    -1,   /* 24: of_bsn_debug_counter_desc_stats_reply */
    -1,   /* 25: of_bsn_debug_counter_desc_stats_request */
    -1,   /* 26: of_bsn_debug_counter_stats_reply */
    -1,   /* 27: of_bsn_debug_counter_stats_request */
    -1,   /* 28: of_bsn_error */
    -1,   /* 29: of_bsn_flow_checksum_bucket_stats_reply */
    -1,   /* 30: of_bsn_flow_checksum_bucket_stats_request */
    -1,   /* 31: of_bsn_flow_idle */
    -1,   /* 32: of_bsn_flow_idle_enable_get_reply */
    -1,   /* 33: of_bsn_flow_idle_enable_get_request */
    -1,   /* 34: of_bsn_flow_idle_enable_set_reply */
    -1,   /* 35: of_bsn_flow_idle_enable_set_request */
    -1,   /* 36: of_bsn_generic_async */
    -1,   /* 37: of_bsn_generic_command */
    -1,   /* 38: of_bsn_generic_stats_reply */
    -1,   /* 39: of_bsn_generic_stats_request */
    -1,   /* 40: of_bsn_gentable_bucket_stats_reply */
    -1,   /* 41: of_bsn_gentable_bucket_stats_request */
    -1,   /* 42: of_bsn_gentable_clear_reply */
    -1,   /* 43: of_bsn_gentable_clear_request */
    -1,   /* 44: of_bsn_gentable_desc_stats_reply */
    -1,   /* 45: of_bsn_gentable_desc_stats_request */
    -1,   /* 46: of_bsn_gentable_entry_add */
    -1,   /* 47: of_bsn_gentable_entry_delete */
    -1,   /* 48: of_bsn_gentable_entry_desc_stats_reply */
    -1,   /* 49: of_bsn_gentable_entry_desc_stats_request */
    -1,   /* 50: of_bsn_gentable_entry_stats_reply */
    -1,   /* 51: of_bsn_gentable_entry_stats_request */
    -1,   /* 52: of_bsn_gentable_set_buckets_size */
    -1,   /* 53: of_bsn_gentable_stats_reply */
    -1,   /* 54: of_bsn_gentable_stats_request */
    16,   /* 55: of_bsn_get_interfaces_reply */
    16,   /* 56: of_bsn_get_interfaces_request */
    24,   /* 57: of_bsn_get_ip_mask_reply */
    24,   /* 58: of_bsn_get_ip_mask_request */
    24,   /* 59: of_bsn_get_l2_table_reply */
    16,   /* 60: of_bsn_get_l2_table_request */
    20,   /* 61: of_bsn_get_mirroring_reply */
    20,   /* 62: of_bsn_get_mirroring_request */
    -1,   /* 63: of_bsn_get_switch_pipeline_reply */
    -1,   /* 64: of_bsn_get_switch_pipeline_request */
    16,   /* 65: of_bsn_header */
    24,   /* 66: of_bsn_hybrid_get_reply */
    16,   /* 67: of_bsn_hybrid_get_request */
    -1,   /* 68: of_bsn_image_desc_stats_reply */
    -1,   /* 69: of_bsn_image_desc_stats_request */
    -1,   /* 70: of_bsn_lacp_convergence_notif */
    -1,   /* 71: of_bsn_lacp_stats_reply */
    -1,   /* 72: of_bsn_lacp_stats_request */
    -1,   /* 73: of_bsn_log */
    -1,   /* 74: of_bsn_lua_command_reply */
    -1,   /* 75: of_bsn_lua_command_request */
    -1,   /* 76: of_bsn_lua_notification */
    -1,   /* 77: of_bsn_lua_upload */
    23,   /* 78: of_bsn_pdu_rx_reply */
    26,   /* 79: of_bsn_pdu_rx_request */
    19,   /* 80: of_bsn_pdu_rx_timeout */
    23,   /* 81: of_bsn_pdu_tx_reply */
    26,   /* 82: of_bsn_pdu_tx_request */
    -1,   /* 83: of_bsn_port_counter_stats_reply */
    -1,   /* 84: of_bsn_port_counter_stats_request */
    -1,   /* 85: of_bsn_role_status */
    -1,   /* 86: of_bsn_set_aux_cxns_reply */
    -1,   /* 87: of_bsn_set_aux_cxns_request */
    24,   /* 88: of_bsn_set_ip_mask */
    24,   /* 89: of_bsn_set_l2_table_reply */
    24,   /* 90: of_bsn_set_l2_table_request */
    -1,   /* 91: of_bsn_set_lacp_reply */
    -1,   /* 92: of_bsn_set_lacp_request */
    20,   /* 93: of_bsn_set_mirroring */
    20,   /* 94: of_bsn_set_pktin_suppression_reply */
    32,   /* 95: of_bsn_set_pktin_suppression_request */
    -1,   /* 96: of_bsn_set_switch_pipeline_reply */
    -1,   /* 97: of_bsn_set_switch_pipeline_request */
    20,   /* 98: of_bsn_shell_command */
    16,   /* 99: of_bsn_shell_output */
    20,   /* 100: of_bsn_shell_status */
    24,   /* 101: of_bsn_stats_reply */
    24,   /* 102: of_bsn_stats_request */
    -1,   /* 103: of_bsn_switch_pipeline_stats_reply */
    -1,   /* 104: of_bsn_switch_pipeline_stats_request */
    -1,   /* 105: of_bsn_table_checksum_stats_reply */
    -1,   /* 106: of_bsn_table_checksum_stats_request */
    -1,   /* 107: of_bsn_table_set_buckets_size */
    -1,   /* 108: of_bsn_takeover */
    -1,   /* 109: of_bsn_time_reply */
    -1,   /* 110: of_bsn_time_request */
    24,   /* 111: of_bsn_virtual_port_create_reply */
    20,   /* 112: of_bsn_virtual_port_create_request */
    20,   /* 113: of_bsn_virtual_port_remove_reply */
    20,   /* 114: of_bsn_virtual_port_remove_request */
    -1,   /* 115: of_bsn_vlan_counter_clear */
    -1,   /* 116: of_bsn_vlan_counter_stats_reply */
    -1,   /* 117: of_bsn_vlan_counter_stats_request */
    -1,   /* 118: of_bsn_vrf_counter_stats_reply */
    -1,   /* 119: of_bsn_vrf_counter_stats_request */
    -1,   /* 120: of_bundle_add_msg */
    -1,   /* 121: of_bundle_ctrl_msg */
    -1,   /* 122: of_bundle_failed_error_msg */
    1068, /* 123: of_desc_stats_reply */
    12,   /* 124: of_desc_stats_request */
    8,    /* 125: of_echo_reply */
    8,    /* 126: of_echo_request */
    10,   /* 127: of_error_msg */
    12,   /* 128: of_experimenter */
    -1,   /* 129: of_experimenter_error_msg */
    16,   /* 130: of_experimenter_stats_reply */
    16,   /* 131: of_experimenter_stats_request */
    32,   /* 132: of_features_reply */
    8,    /* 133: of_features_request */
    72,   /* 134: of_flow_add */
    72,   /* 135: of_flow_delete */
    72,   /* 136: of_flow_delete_strict */
    72,   /* 137: of_flow_mod */
    12,   /* 138: of_flow_mod_failed_error_msg */
    72,   /* 139: of_flow_modify */
    72,   /* 140: of_flow_modify_strict */
    -1,   /* 141: of_flow_monitor_failed_error_msg */
    88,   /* 142: of_flow_removed */
    12,   /* 143: of_flow_stats_reply */
    56,   /* 144: of_flow_stats_request */
    12,   /* 145: of_get_config_reply */
    8,    /* 146: of_get_config_request */
    -1,   /* 147: of_group_add */
    -1,   /* 148: of_group_delete */
    -1,   /* 149: of_group_desc_stats_reply */
    -1,   /* 150: of_group_desc_stats_request */
    -1,   /* 151: of_group_features_stats_reply */
    -1,   /* 152: of_group_features_stats_request */
    -1,   /* 153: of_group_mod */
    -1,   /* 154: of_group_mod_failed_error_msg */
    -1,   /* 155: of_group_modify */
    -1,   /* 156: of_group_stats_reply */
    -1,   /* 157: of_group_stats_request */
    8,    /* 158: of_header */
    8,    /* 159: of_hello */
    12,   /* 160: of_hello_failed_error_msg */
    -1,   /* 161: of_meter_config_stats_reply */
    -1,   /* 162: of_meter_config_stats_request */
    -1,   /* 163: of_meter_features_stats_reply */
    -1,   /* 164: of_meter_features_stats_request */
    -1,   /* 165: of_meter_mod */
    -1,   /* 166: of_meter_mod_failed_error_msg */
    -1,   /* 167: of_meter_stats_reply */
    -1,   /* 168: of_meter_stats_request */
    20,   /* 169: of_nicira_controller_role_reply */
    20,   /* 170: of_nicira_controller_role_request */
    16,   /* 171: of_nicira_header */
    18,   /* 172: of_packet_in */
    16,   /* 173: of_packet_out */
    -1,   /* 174: of_port_desc_stats_reply */
    -1,   /* 175: of_port_desc_stats_request */
    32,   /* 176: of_port_mod */
    12,   /* 177: of_port_mod_failed_error_msg */
    12,   /* 178: of_port_stats_reply */
    20,   /* 179: of_port_stats_request */
    64,   /* 180: of_port_status */
    -1,   /* 181: of_queue_desc_stats_reply */
    -1,   /* 182: of_queue_desc_stats_request */
    16,   /* 183: of_queue_get_config_reply */
    12,   /* 184: of_queue_get_config_request */
    12,   /* 185: of_queue_op_failed_error_msg */
    12,   /* 186: of_queue_stats_reply */
    20,   /* 187: of_queue_stats_request */
    -1,   /* 188: of_requestforward */
    -1,   /* 189: of_role_reply */
    -1,   /* 190: of_role_request */
    -1,   /* 191: of_role_request_failed_error_msg */
    -1,   /* 192: of_role_status */
    12,   /* 193: of_set_config */
    12,   /* 194: of_stats_reply */
    12,   /* 195: of_stats_request */
    -1,   /* 196: of_switch_config_failed_error_msg */
    -1,   /* 197: of_table_desc_stats_reply */
    -1,   /* 198: of_table_desc_stats_request */
    -1,   /* 199: of_table_features_failed_error_msg */
    -1,   /* 200: of_table_features_stats_reply */
    -1,   /* 201: of_table_features_stats_request */
    16,   /* 202: of_table_mod */
    -1,   /* 203: of_table_mod_failed_error_msg */
    12,   /* 204: of_table_stats_reply */
    12,   /* 205: of_table_stats_request */
    -1,   /* 206: of_table_status */
    8,    /* 207: of_action */
    16,   /* 208: of_action_bsn */
    28,   /* 209: of_action_bsn_checksum */
    -1,   /* 210: of_action_bsn_gentable */
    24,   /* 211: of_action_bsn_mirror */
    16,   /* 212: of_action_bsn_set_tunnel_dst */
    -1,   /* 213: of_action_copy_ttl_in */
    -1,   /* 214: of_action_copy_ttl_out */
    -1,   /* 215: of_action_dec_mpls_ttl */
    -1,   /* 216: of_action_dec_nw_ttl */
    16,   /* 217: of_action_enqueue */
    8,    /* 218: of_action_experimenter */
    -1,   /* 219: of_action_group */
    -1,   /* 220: of_action_id */
    -1,   /* 221: of_action_id_bsn */
    -1,   /* 222: of_action_id_bsn_checksum */
    -1,   /* 223: of_action_id_bsn_gentable */
    -1,   /* 224: of_action_id_bsn_mirror */
    -1,   /* 225: of_action_id_bsn_set_tunnel_dst */
    -1,   /* 226: of_action_id_copy_ttl_in */
    -1,   /* 227: of_action_id_copy_ttl_out */
    -1,   /* 228: of_action_id_dec_mpls_ttl */
    -1,   /* 229: of_action_id_dec_nw_ttl */
    -1,   /* 230: of_action_id_experimenter */
    -1,   /* 231: of_action_id_group */
    -1,   /* 232: of_action_id_nicira */
    -1,   /* 233: of_action_id_nicira_dec_ttl */
    -1,   /* 234: of_action_id_output */
    -1,   /* 235: of_action_id_pop_mpls */
    -1,   /* 236: of_action_id_pop_pbb */
    -1,   /* 237: of_action_id_pop_vlan */
    -1,   /* 238: of_action_id_push_mpls */
    -1,   /* 239: of_action_id_push_pbb */
    -1,   /* 240: of_action_id_push_vlan */
    -1,   /* 241: of_action_id_set_field */
    -1,   /* 242: of_action_id_set_mpls_ttl */
    -1,   /* 243: of_action_id_set_nw_ttl */
    -1,   /* 244: of_action_id_set_queue */
    16,   /* 245: of_action_nicira */
    16,   /* 246: of_action_nicira_dec_ttl */
    8,    /* 247: of_action_output */
    -1,   /* 248: of_action_pop_mpls */
    -1,   /* 249: of_action_pop_pbb */
    -1,   /* 250: of_action_pop_vlan */
    -1,   /* 251: of_action_push_mpls */
    -1,   /* 252: of_action_push_pbb */
    -1,   /* 253: of_action_push_vlan */
    16,   /* 254: of_action_set_dl_dst */
    16,   /* 255: of_action_set_dl_src */
    -1,   /* 256: of_action_set_field */
    -1,   /* 257: of_action_set_mpls_label */
    -1,   /* 258: of_action_set_mpls_tc */
    -1,   /* 259: of_action_set_mpls_ttl */
    8,    /* 260: of_action_set_nw_dst */
    -1,   /* 261: of_action_set_nw_ecn */
    8,    /* 262: of_action_set_nw_src */
    8,    /* 263: of_action_set_nw_tos */
    -1,   /* 264: of_action_set_nw_ttl */
    -1,   /* 265: of_action_set_queue */
    8,    /* 266: of_action_set_tp_dst */
    8,    /* 267: of_action_set_tp_src */
    8,    /* 268: of_action_set_vlan_pcp */
    8,    /* 269: of_action_set_vlan_vid */
    8,    /* 270: of_action_strip_vlan */
    -1,   /* 271: of_async_config_prop */
    -1,   /* 272: of_async_config_prop_experimenter_master */
    -1,   /* 273: of_async_config_prop_experimenter_slave */
    -1,   /* 274: of_async_config_prop_flow_removed_master */
    -1,   /* 275: of_async_config_prop_flow_removed_slave */
    -1,   /* 276: of_async_config_prop_packet_in_master */
    -1,   /* 277: of_async_config_prop_packet_in_slave */
    -1,   /* 278: of_async_config_prop_port_status_master */
    -1,   /* 279: of_async_config_prop_port_status_slave */
    -1,   /* 280: of_async_config_prop_requestforward_master */
    -1,   /* 281: of_async_config_prop_requestforward_slave */
    -1,   /* 282: of_async_config_prop_role_status_master */
    -1,   /* 283: of_async_config_prop_role_status_slave */
    -1,   /* 284: of_async_config_prop_table_status_master */
    -1,   /* 285: of_async_config_prop_table_status_slave */
    -1,   /* 286: of_bsn_controller_connection */
    -1,   /* 287: of_bsn_debug_counter_desc_stats_entry */
    -1,   /* 288: of_bsn_debug_counter_stats_entry */
    -1,   /* 289: of_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 290: of_bsn_generic_stats_entry */
    -1,   /* 291: of_bsn_gentable_bucket_stats_entry */
    -1,   /* 292: of_bsn_gentable_desc_stats_entry */
    -1,   /* 293: of_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 294: of_bsn_gentable_entry_stats_entry */
    -1,   /* 295: of_bsn_gentable_stats_entry */
    32,   /* 296: of_bsn_interface */
    -1,   /* 297: of_bsn_lacp_stats_entry */
    -1,   /* 298: of_bsn_port_counter_stats_entry */
    -1,   /* 299: of_bsn_switch_pipeline_stats_entry */
    -1,   /* 300: of_bsn_table_checksum_stats_entry */
    -1,   /* 301: of_bsn_tlv */
    -1,   /* 302: of_bsn_tlv_actor_key */
    -1,   /* 303: of_bsn_tlv_actor_port_num */
    -1,   /* 304: of_bsn_tlv_actor_port_priority */
    -1,   /* 305: of_bsn_tlv_actor_state */
    -1,   /* 306: of_bsn_tlv_actor_system_mac */
    -1,   /* 307: of_bsn_tlv_actor_system_priority */
    -1,   /* 308: of_bsn_tlv_anchor */
    -1,   /* 309: of_bsn_tlv_broadcast_query_timeout */
    -1,   /* 310: of_bsn_tlv_broadcast_rate */
    -1,   /* 311: of_bsn_tlv_bucket */
    -1,   /* 312: of_bsn_tlv_circuit_id */
    -1,   /* 313: of_bsn_tlv_convergence_status */
    -1,   /* 314: of_bsn_tlv_crc_enabled */
    -1,   /* 315: of_bsn_tlv_data */
    -1,   /* 316: of_bsn_tlv_decap */
    -1,   /* 317: of_bsn_tlv_eth_dst */
    -1,   /* 318: of_bsn_tlv_eth_src */
    -1,   /* 319: of_bsn_tlv_external_gateway_ip */
    -1,   /* 320: of_bsn_tlv_external_gateway_mac */
    -1,   /* 321: of_bsn_tlv_external_ip */
    -1,   /* 322: of_bsn_tlv_external_mac */
    -1,   /* 323: of_bsn_tlv_external_netmask */
    -1,   /* 324: of_bsn_tlv_generation_id */
    -1,   /* 325: of_bsn_tlv_header_size */
    -1,   /* 326: of_bsn_tlv_icmp_code */
    -1,   /* 327: of_bsn_tlv_icmp_id */
    -1,   /* 328: of_bsn_tlv_icmp_type */
    -1,   /* 329: of_bsn_tlv_idle_notification */
    -1,   /* 330: of_bsn_tlv_idle_time */
    -1,   /* 331: of_bsn_tlv_idle_timeout */
    -1,   /* 332: of_bsn_tlv_igmp_snooping */
    -1,   /* 333: of_bsn_tlv_internal_gateway_mac */
    -1,   /* 334: of_bsn_tlv_internal_mac */
    -1,   /* 335: of_bsn_tlv_interval */
    -1,   /* 336: of_bsn_tlv_ip_proto */
    -1,   /* 337: of_bsn_tlv_ipv4 */
    -1,   /* 338: of_bsn_tlv_ipv4_dst */
    -1,   /* 339: of_bsn_tlv_ipv4_netmask */
    -1,   /* 340: of_bsn_tlv_ipv4_src */
    -1,   /* 341: of_bsn_tlv_ipv6 */
    -1,   /* 342: of_bsn_tlv_known_multicast_rate */
    -1,   /* 343: of_bsn_tlv_l2_multicast_lookup */
    -1,   /* 344: of_bsn_tlv_mac */
    -1,   /* 345: of_bsn_tlv_mac_mask */
    -1,   /* 346: of_bsn_tlv_mcg_type_vxlan */
    -1,   /* 347: of_bsn_tlv_miss_packets */
    -1,   /* 348: of_bsn_tlv_mpls_control_word */
    -1,   /* 349: of_bsn_tlv_mpls_label */
    -1,   /* 350: of_bsn_tlv_mpls_sequenced */
    -1,   /* 351: of_bsn_tlv_multicast_interface_id */
    -1,   /* 352: of_bsn_tlv_name */
    -1,   /* 353: of_bsn_tlv_negate */
    -1,   /* 354: of_bsn_tlv_nexthop_type_vxlan */
    -1,   /* 355: of_bsn_tlv_offset */
    -1,   /* 356: of_bsn_tlv_partner_key */
    -1,   /* 357: of_bsn_tlv_partner_port_num */
    -1,   /* 358: of_bsn_tlv_partner_port_priority */
    -1,   /* 359: of_bsn_tlv_partner_state */
    -1,   /* 360: of_bsn_tlv_partner_system_mac */
    -1,   /* 361: of_bsn_tlv_partner_system_priority */
    -1,   /* 362: of_bsn_tlv_port */
    -1,   /* 363: of_bsn_tlv_port_vxlan_mode */
    -1,   /* 364: of_bsn_tlv_priority */
    -1,   /* 365: of_bsn_tlv_queue_id */
    -1,   /* 366: of_bsn_tlv_queue_weight */
    -1,   /* 367: of_bsn_tlv_rate_unit */
    -1,   /* 368: of_bsn_tlv_reference */
    -1,   /* 369: of_bsn_tlv_reply_packets */
    -1,   /* 370: of_bsn_tlv_request_packets */
    -1,   /* 371: of_bsn_tlv_rx_bytes */
    -1,   /* 372: of_bsn_tlv_rx_packets */
    -1,   /* 373: of_bsn_tlv_sampling_rate */
    -1,   /* 374: of_bsn_tlv_set_loopback_mode */
    -1,   /* 375: of_bsn_tlv_status */
    -1,   /* 376: of_bsn_tlv_strip_mpls_l2_on_ingress */
    -1,   /* 377: of_bsn_tlv_strip_mpls_l3_on_ingress */
    -1,   /* 378: of_bsn_tlv_strip_vlan_on_egress */
    -1,   /* 379: of_bsn_tlv_sub_agent_id */
    -1,   /* 380: of_bsn_tlv_tcp_dst */
    -1,   /* 381: of_bsn_tlv_tcp_src */
    -1,   /* 382: of_bsn_tlv_tx_bytes */
    -1,   /* 383: of_bsn_tlv_tx_packets */
    -1,   /* 384: of_bsn_tlv_udf_anchor */
    -1,   /* 385: of_bsn_tlv_udf_id */
    -1,   /* 386: of_bsn_tlv_udf_length */
    -1,   /* 387: of_bsn_tlv_udf_offset */
    -1,   /* 388: of_bsn_tlv_udp_dst */
    -1,   /* 389: of_bsn_tlv_udp_src */
    -1,   /* 390: of_bsn_tlv_unicast_query_timeout */
    -1,   /* 391: of_bsn_tlv_unicast_rate */
    -1,   /* 392: of_bsn_tlv_unknown_multicast_rate */
    -1,   /* 393: of_bsn_tlv_use_packet_state */
    -1,   /* 394: of_bsn_tlv_vfi */
    -1,   /* 395: of_bsn_tlv_vlan_mac_list */
    -1,   /* 396: of_bsn_tlv_vlan_pcp */
    -1,   /* 397: of_bsn_tlv_vlan_vid */
    -1,   /* 398: of_bsn_tlv_vlan_vid_mask */
    -1,   /* 399: of_bsn_tlv_vni */
    -1,   /* 400: of_bsn_tlv_vrf */
    -1,   /* 401: of_bsn_vlan_counter_stats_entry */
    -1,   /* 402: of_bsn_vlan_mac */
    4,    /* 403: of_bsn_vport */
    60,   /* 404: of_bsn_vport_l2gre */
    32,   /* 405: of_bsn_vport_q_in_q */
    -1,   /* 406: of_bsn_vrf_counter_stats_entry */
    -1,   /* 407: of_bucket */
    -1,   /* 408: of_bucket_counter */
    -1,   /* 409: of_bundle_prop */
    -1,   /* 410: of_bundle_prop_experimenter */
    88,   /* 411: of_flow_stats_entry */
    -1,   /* 412: of_group_desc_stats_entry */
    -1,   /* 413: of_group_stats_entry */
    -1,   /* 414: of_hello_elem */
    -1,   /* 415: of_hello_elem_versionbitmap */
    -1,   /* 416: of_instruction */
    -1,   /* 417: of_instruction_apply_actions */
    -1,   /* 418: of_instruction_bsn */
    -1,   /* 419: of_instruction_bsn_arp_offload */
    -1,   /* 420: of_instruction_bsn_auto_negotiation */
    -1,   /* 421: of_instruction_bsn_deny */
    -1,   /* 422: of_instruction_bsn_dhcp_offload */
    -1,   /* 423: of_instruction_bsn_disable_l3 */
    -1,   /* 424: of_instruction_bsn_disable_split_horizon_check */
    -1,   /* 425: of_instruction_bsn_disable_src_mac_check */
    -1,   /* 426: of_instruction_bsn_disable_vlan_counters */
    -1,   /* 427: of_instruction_bsn_internal_priority */
    -1,   /* 428: of_instruction_bsn_packet_of_death */
    -1,   /* 429: of_instruction_bsn_permit */
    -1,   /* 430: of_instruction_bsn_prioritize_pdus */
    -1,   /* 431: of_instruction_bsn_require_vlan_xlate */
    -1,   /* 432: of_instruction_bsn_span_destination */
    -1,   /* 433: of_instruction_clear_actions */
    -1,   /* 434: of_instruction_experimenter */
    -1,   /* 435: of_instruction_goto_table */
    -1,   /* 436: of_instruction_id */
    -1,   /* 437: of_instruction_id_apply_actions */
    -1,   /* 438: of_instruction_id_bsn */
    -1,   /* 439: of_instruction_id_bsn_arp_offload */
    -1,   /* 440: of_instruction_id_bsn_auto_negotiation */
    -1,   /* 441: of_instruction_id_bsn_deny */
    -1,   /* 442: of_instruction_id_bsn_dhcp_offload */
    -1,   /* 443: of_instruction_id_bsn_disable_l3 */
    -1,   /* 444: of_instruction_id_bsn_disable_split_horizon_check */
    -1,   /* 445: of_instruction_id_bsn_disable_src_mac_check */
    -1,   /* 446: of_instruction_id_bsn_disable_vlan_counters */
    -1,   /* 447: of_instruction_id_bsn_internal_priority */
    -1,   /* 448: of_instruction_id_bsn_packet_of_death */
    -1,   /* 449: of_instruction_id_bsn_permit */
    -1,   /* 450: of_instruction_id_bsn_prioritize_pdus */
    -1,   /* 451: of_instruction_id_bsn_require_vlan_xlate */
    -1,   /* 452: of_instruction_id_bsn_span_destination */
    -1,   /* 453: of_instruction_id_clear_actions */
    -1,   /* 454: of_instruction_id_experimenter */
    -1,   /* 455: of_instruction_id_goto_table */
    -1,   /* 456: of_instruction_id_meter */
    -1,   /* 457: of_instruction_id_write_actions */
    -1,   /* 458: of_instruction_id_write_metadata */
    -1,   /* 459: of_instruction_meter */
    -1,   /* 460: of_instruction_write_actions */
    -1,   /* 461: of_instruction_write_metadata */
    40,   /* 462: of_match_v1 */
    -1,   /* 463: of_match_v2 */
    -1,   /* 464: of_match_v3 */
    -1,   /* 465: of_meter_band */
    -1,   /* 466: of_meter_band_drop */
    -1,   /* 467: of_meter_band_dscp_remark */
    -1,   /* 468: of_meter_band_experimenter */
    -1,   /* 469: of_meter_band_stats */
    -1,   /* 470: of_meter_config */
    -1,   /* 471: of_meter_features */
    -1,   /* 472: of_meter_stats */
    -1,   /* 473: of_oxm */
    -1,   /* 474: of_oxm_arp_op */
    -1,   /* 475: of_oxm_arp_op_masked */
    -1,   /* 476: of_oxm_arp_sha */
    -1,   /* 477: of_oxm_arp_sha_masked */
    -1,   /* 478: of_oxm_arp_spa */
    -1,   /* 479: of_oxm_arp_spa_masked */
    -1,   /* 480: of_oxm_arp_tha */
    -1,   /* 481: of_oxm_arp_tha_masked */
    -1,   /* 482: of_oxm_arp_tpa */
    -1,   /* 483: of_oxm_arp_tpa_masked */
    -1,   /* 484: of_oxm_bsn_egr_port_group_id */
    -1,   /* 485: of_oxm_bsn_egr_port_group_id_masked */
    -1,   /* 486: of_oxm_bsn_global_vrf_allowed */
    -1,   /* 487: of_oxm_bsn_global_vrf_allowed_masked */
    -1,   /* 488: of_oxm_bsn_in_ports_128 */
    -1,   /* 489: of_oxm_bsn_in_ports_128_masked */
    -1,   /* 490: of_oxm_bsn_in_ports_512 */
    -1,   /* 491: of_oxm_bsn_in_ports_512_masked */
    -1,   /* 492: of_oxm_bsn_ingress_port_group_id */
    -1,   /* 493: of_oxm_bsn_ingress_port_group_id_masked */
    -1,   /* 494: of_oxm_bsn_inner_eth_dst */
    -1,   /* 495: of_oxm_bsn_inner_eth_dst_masked */
    -1,   /* 496: of_oxm_bsn_inner_eth_src */
    -1,   /* 497: of_oxm_bsn_inner_eth_src_masked */
    -1,   /* 498: of_oxm_bsn_inner_vlan_vid */
    -1,   /* 499: of_oxm_bsn_inner_vlan_vid_masked */
    -1,   /* 500: of_oxm_bsn_l2_cache_hit */
    -1,   /* 501: of_oxm_bsn_l2_cache_hit_masked */
    -1,   /* 502: of_oxm_bsn_l3_dst_class_id */
    -1,   /* 503: of_oxm_bsn_l3_dst_class_id_masked */
    -1,   /* 504: of_oxm_bsn_l3_interface_class_id */
    -1,   /* 505: of_oxm_bsn_l3_interface_class_id_masked */
    -1,   /* 506: of_oxm_bsn_l3_src_class_id */
    -1,   /* 507: of_oxm_bsn_l3_src_class_id_masked */
    -1,   /* 508: of_oxm_bsn_lag_id */
    -1,   /* 509: of_oxm_bsn_lag_id_masked */
    -1,   /* 510: of_oxm_bsn_tcp_flags */
    -1,   /* 511: of_oxm_bsn_tcp_flags_masked */
    -1,   /* 512: of_oxm_bsn_udf0 */
    -1,   /* 513: of_oxm_bsn_udf0_masked */
    -1,   /* 514: of_oxm_bsn_udf1 */
    -1,   /* 515: of_oxm_bsn_udf1_masked */
    -1,   /* 516: of_oxm_bsn_udf2 */
    -1,   /* 517: of_oxm_bsn_udf2_masked */
    -1,   /* 518: of_oxm_bsn_udf3 */
    -1,   /* 519: of_oxm_bsn_udf3_masked */
    -1,   /* 520: of_oxm_bsn_udf4 */
    -1,   /* 521: of_oxm_bsn_udf4_masked */
    -1,   /* 522: of_oxm_bsn_udf5 */
    -1,   /* 523: of_oxm_bsn_udf5_masked */
    -1,   /* 524: of_oxm_bsn_udf6 */
    -1,   /* 525: of_oxm_bsn_udf6_masked */
    -1,   /* 526: of_oxm_bsn_udf7 */
    -1,   /* 527: of_oxm_bsn_udf7_masked */
    -1,   /* 528: of_oxm_bsn_vlan_xlate_port_group_id */
    -1,   /* 529: of_oxm_bsn_vlan_xlate_port_group_id_masked */
    -1,   /* 530: of_oxm_bsn_vrf */
    -1,   /* 531: of_oxm_bsn_vrf_masked */
    -1,   /* 532: of_oxm_bsn_vxlan_network_id */
    -1,   /* 533: of_oxm_bsn_vxlan_network_id_masked */
    -1,   /* 534: of_oxm_eth_dst */
    -1,   /* 535: of_oxm_eth_dst_masked */
    -1,   /* 536: of_oxm_eth_src */
    -1,   /* 537: of_oxm_eth_src_masked */
    -1,   /* 538: of_oxm_eth_type */
    -1,   /* 539: of_oxm_eth_type_masked */
    -1,   /* 540: of_oxm_icmpv4_code */
    -1,   /* 541: of_oxm_icmpv4_code_masked */
    -1,   /* 542: of_oxm_icmpv4_type */
    -1,   /* 543: of_oxm_icmpv4_type_masked */
    -1,   /* 544: of_oxm_icmpv6_code */
    -1,   /* 545: of_oxm_icmpv6_code_masked */
    -1,   /* 546: of_oxm_icmpv6_type */
    -1,   /* 547: of_oxm_icmpv6_type_masked */
    -1,   /* 548: of_oxm_in_phy_port */
    -1,   /* 549: of_oxm_in_phy_port_masked */
    -1,   /* 550: of_oxm_in_port */
    -1,   /* 551: of_oxm_in_port_masked */
    -1,   /* 552: of_oxm_ip_dscp */
    -1,   /* 553: of_oxm_ip_dscp_masked */
    -1,   /* 554: of_oxm_ip_ecn */
    -1,   /* 555: of_oxm_ip_ecn_masked */
    -1,   /* 556: of_oxm_ip_proto */
    -1,   /* 557: of_oxm_ip_proto_masked */
    -1,   /* 558: of_oxm_ipv4_dst */
    -1,   /* 559: of_oxm_ipv4_dst_masked */
    -1,   /* 560: of_oxm_ipv4_src */
    -1,   /* 561: of_oxm_ipv4_src_masked */
    -1,   /* 562: of_oxm_ipv6_dst */
    -1,   /* 563: of_oxm_ipv6_dst_masked */
    -1,   /* 564: of_oxm_ipv6_exthdr */
    -1,   /* 565: of_oxm_ipv6_exthdr_masked */
    -1,   /* 566: of_oxm_ipv6_flabel */
    -1,   /* 567: of_oxm_ipv6_flabel_masked */
    -1,   /* 568: of_oxm_ipv6_nd_sll */
    -1,   /* 569: of_oxm_ipv6_nd_sll_masked */
    -1,   /* 570: of_oxm_ipv6_nd_target */
    -1,   /* 571: of_oxm_ipv6_nd_target_masked */
    -1,   /* 572: of_oxm_ipv6_nd_tll */
    -1,   /* 573: of_oxm_ipv6_nd_tll_masked */
    -1,   /* 574: of_oxm_ipv6_src */
    -1,   /* 575: of_oxm_ipv6_src_masked */
    -1,   /* 576: of_oxm_metadata */
    -1,   /* 577: of_oxm_metadata_masked */
    -1,   /* 578: of_oxm_mpls_bos */
    -1,   /* 579: of_oxm_mpls_bos_masked */
    -1,   /* 580: of_oxm_mpls_label */
    -1,   /* 581: of_oxm_mpls_label_masked */
    -1,   /* 582: of_oxm_mpls_tc */
    -1,   /* 583: of_oxm_mpls_tc_masked */
    -1,   /* 584: of_oxm_pbb_uca */
    -1,   /* 585: of_oxm_pbb_uca_masked */
    -1,   /* 586: of_oxm_sctp_dst */
    -1,   /* 587: of_oxm_sctp_dst_masked */
    -1,   /* 588: of_oxm_sctp_src */
    -1,   /* 589: of_oxm_sctp_src_masked */
    -1,   /* 590: of_oxm_tcp_dst */
    -1,   /* 591: of_oxm_tcp_dst_masked */
    -1,   /* 592: of_oxm_tcp_src */
    -1,   /* 593: of_oxm_tcp_src_masked */
    -1,   /* 594: of_oxm_tunnel_id */
    -1,   /* 595: of_oxm_tunnel_id_masked */
    -1,   /* 596: of_oxm_tunnel_ipv4_dst */
    -1,   /* 597: of_oxm_tunnel_ipv4_dst_masked */
    -1,   /* 598: of_oxm_tunnel_ipv4_src */
    -1,   /* 599: of_oxm_tunnel_ipv4_src_masked */
    -1,   /* 600: of_oxm_udp_dst */
    -1,   /* 601: of_oxm_udp_dst_masked */
    -1,   /* 602: of_oxm_udp_src */
    -1,   /* 603: of_oxm_udp_src_masked */
    -1,   /* 604: of_oxm_vlan_pcp */
    -1,   /* 605: of_oxm_vlan_pcp_masked */
    -1,   /* 606: of_oxm_vlan_vid */
    -1,   /* 607: of_oxm_vlan_vid_masked */
    8,    /* 608: of_packet_queue */
    48,   /* 609: of_port_desc */
    -1,   /* 610: of_port_desc_prop */
    -1,   /* 611: of_port_desc_prop_bsn */
    -1,   /* 612: of_port_desc_prop_bsn_generation_id */
    -1,   /* 613: of_port_desc_prop_bsn_uplink */
    -1,   /* 614: of_port_desc_prop_ethernet */
    -1,   /* 615: of_port_desc_prop_experimenter */
    -1,   /* 616: of_port_desc_prop_optical */
    -1,   /* 617: of_port_mod_prop */
    -1,   /* 618: of_port_mod_prop_ethernet */
    -1,   /* 619: of_port_mod_prop_experimenter */
    -1,   /* 620: of_port_mod_prop_optical */
    104,  /* 621: of_port_stats_entry */
    -1,   /* 622: of_port_stats_prop */
    -1,   /* 623: of_port_stats_prop_ethernet */
    -1,   /* 624: of_port_stats_prop_experimenter */
    -1,   /* 625: of_port_stats_prop_optical */
    -1,   /* 626: of_queue_desc */
    -1,   /* 627: of_queue_desc_prop */
    -1,   /* 628: of_queue_desc_prop_experimenter */
    -1,   /* 629: of_queue_desc_prop_max_rate */
    -1,   /* 630: of_queue_desc_prop_min_rate */
    8,    /* 631: of_queue_prop */
    -1,   /* 632: of_queue_prop_experimenter */
    -1,   /* 633: of_queue_prop_max_rate */
    16,   /* 634: of_queue_prop_min_rate */
    32,   /* 635: of_queue_stats_entry */
    -1,   /* 636: of_queue_stats_prop */
    -1,   /* 637: of_queue_stats_prop_experimenter */
    -1,   /* 638: of_role_prop */
    -1,   /* 639: of_role_prop_experimenter */
    -1,   /* 640: of_table_desc */
    -1,   /* 641: of_table_feature_prop */
    -1,   /* 642: of_table_feature_prop_apply_actions */
    -1,   /* 643: of_table_feature_prop_apply_actions_miss */
    -1,   /* 644: of_table_feature_prop_apply_setfield */
    -1,   /* 645: of_table_feature_prop_apply_setfield_miss */
    -1,   /* 646: of_table_feature_prop_experimenter */
    -1,   /* 647: of_table_feature_prop_experimenter_miss */
    -1,   /* 648: of_table_feature_prop_instructions */
    -1,   /* 649: of_table_feature_prop_instructions_miss */
    -1,   /* 650: of_table_feature_prop_match */
    -1,   /* 651: of_table_feature_prop_next_tables */
    -1,   /* 652: of_table_feature_prop_next_tables_miss */
    -1,   /* 653: of_table_feature_prop_table_sync_from */
    -1,   /* 654: of_table_feature_prop_wildcards */
    -1,   /* 655: of_table_feature_prop_write_actions */
    -1,   /* 656: of_table_feature_prop_write_actions_miss */
    -1,   /* 657: of_table_feature_prop_write_setfield */
    -1,   /* 658: of_table_feature_prop_write_setfield_miss */
    -1,   /* 659: of_table_features */
    -1,   /* 660: of_table_mod_prop */
    -1,   /* 661: of_table_mod_prop_eviction */
    -1,   /* 662: of_table_mod_prop_experimenter */
    -1,   /* 663: of_table_mod_prop_vacancy */
    64,   /* 664: of_table_stats_entry */
    -1,   /* 665: of_uint32 */
    -1,   /* 666: of_uint64 */
    -1,   /* 667: of_uint8 */
    0,    /* 668: of_list_action */
    -1,   /* 669: of_list_action_id */
    -1,   /* 670: of_list_async_config_prop */
    -1,   /* 671: of_list_bsn_controller_connection */
    -1,   /* 672: of_list_bsn_debug_counter_desc_stats_entry */
    -1,   /* 673: of_list_bsn_debug_counter_stats_entry */
    -1,   /* 674: of_list_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 675: of_list_bsn_generic_stats_entry */
    -1,   /* 676: of_list_bsn_gentable_bucket_stats_entry */
    -1,   /* 677: of_list_bsn_gentable_desc_stats_entry */
    -1,   /* 678: of_list_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 679: of_list_bsn_gentable_entry_stats_entry */
    -1,   /* 680: of_list_bsn_gentable_stats_entry */
    0,    /* 681: of_list_bsn_interface */
    -1,   /* 682: of_list_bsn_lacp_stats_entry */
    -1,   /* 683: of_list_bsn_port_counter_stats_entry */
    -1,   /* 684: of_list_bsn_switch_pipeline_stats_entry */
    -1,   /* 685: of_list_bsn_table_checksum_stats_entry */
    -1,   /* 686: of_list_bsn_tlv */
    -1,   /* 687: of_list_bsn_vlan_counter_stats_entry */
    -1,   /* 688: of_list_bsn_vlan_mac */
    -1,   /* 689: of_list_bsn_vrf_counter_stats_entry */
    -1,   /* 690: of_list_bucket */
    -1,   /* 691: of_list_bucket_counter */
    -1,   /* 692: of_list_bundle_prop */
    0,    /* 693: of_list_flow_stats_entry */
    -1,   /* 694: of_list_group_desc_stats_entry */
    -1,   /* 695: of_list_group_stats_entry */
    -1,   /* 696: of_list_hello_elem */
    -1,   /* 697: of_list_instruction */
    -1,   /* 698: of_list_instruction_id */
    -1,   /* 699: of_list_meter_band */
    -1,   /* 700: of_list_meter_band_stats */
    -1,   /* 701: of_list_meter_config */
    -1,   /* 702: of_list_meter_stats */
    -1,   /* 703: of_list_oxm */
    0,    /* 704: of_list_packet_queue */
    0,    /* 705: of_list_port_desc */
    -1,   /* 706: of_list_port_desc_prop */
    -1,   /* 707: of_list_port_mod_prop */
    0,    /* 708: of_list_port_stats_entry */
    -1,   /* 709: of_list_port_stats_prop */
    -1,   /* 710: of_list_queue_desc */
    -1,   /* 711: of_list_queue_desc_prop */
    0,    /* 712: of_list_queue_prop */
    0,    /* 713: of_list_queue_stats_entry */
    -1,   /* 714: of_list_queue_stats_prop */
    -1,   /* 715: of_list_role_prop */
    -1,   /* 716: of_list_table_desc */
    -1,   /* 717: of_list_table_feature_prop */
    -1,   /* 718: of_list_table_features */
    -1,   /* 719: of_list_table_mod_prop */
    0,    /* 720: of_list_table_stats_entry */
    -1,   /* 721: of_list_uint32 */
    -1,   /* 722: of_list_uint64 */
    -1    /* 723: of_list_uint8 */
};

static const int
of_object_fixed_len_v2[OF_OBJECT_COUNT] = {
    -1,   /* of_object is not instantiable */
    40,   /* 1: of_aggregate_stats_reply */
    136,  /* 2: of_aggregate_stats_request */
    -1,   /* 3: of_async_config_failed_error_msg */
    -1,   /* 4: of_async_get_reply */
    -1,   /* 5: of_async_get_request */
    -1,   /* 6: of_async_set */
    12,   /* 7: of_bad_action_error_msg */
    12,   /* 8: of_bad_instruction_error_msg */
    12,   /* 9: of_bad_match_error_msg */
    -1,   /* 10: of_bad_property_error_msg */
    12,   /* 11: of_bad_request_error_msg */
    8,    /* 12: of_barrier_reply */
    8,    /* 13: of_barrier_request */
    -1,   /* 14: of_bsn_arp_idle */
    -1,   /* 15: of_bsn_base_error */
    20,   /* 16: of_bsn_bw_clear_data_reply */
    16,   /* 17: of_bsn_bw_clear_data_request */
    20,   /* 18: of_bsn_bw_enable_get_reply */
    16,   /* 19: of_bsn_bw_enable_get_request */
    24,   /* 20: of_bsn_bw_enable_set_reply */
    20,   /* 21: of_bsn_bw_enable_set_request */
    -1,   /* 22: of_bsn_controller_connections_reply */
    -1,   /* 23: of_bsn_controller_connections_request */
    -1,   /* 24: of_bsn_debug_counter_desc_stats_reply */
    -1,   /* 25: of_bsn_debug_counter_desc_stats_request */
    -1,   /* 26: of_bsn_debug_counter_stats_reply */
    -1,   /* 27: of_bsn_debug_counter_stats_request */
    -1,   /* 28: of_bsn_error */
    -1,   /* 29: of_bsn_flow_checksum_bucket_stats_reply */
    -1,   /* 30: of_bsn_flow_checksum_bucket_stats_request */
    -1,   /* 31: of_bsn_flow_idle */
    -1,   /* 32: of_bsn_flow_idle_enable_get_reply */
    -1,   /* 33: of_bsn_flow_idle_enable_get_request */
    -1,   /* 34: of_bsn_flow_idle_enable_set_reply */
    -1,   /* 35: of_bsn_flow_idle_enable_set_request */
    -1,   /* 36: of_bsn_generic_async */
    -1,   /* 37: of_bsn_generic_command */
    -1,   /* 38: of_bsn_generic_stats_reply */
    -1,   /* 39: of_bsn_generic_stats_request */
    -1,   /* 40: of_bsn_gentable_bucket_stats_reply */
    -1,   /* 41: of_bsn_gentable_bucket_stats_request */
    -1,   /* 42: of_bsn_gentable_clear_reply */
    -1,   /* 43: of_bsn_gentable_clear_request */
    -1,   /* 44: of_bsn_gentable_desc_stats_reply */
    -1,   /* 45: of_bsn_gentable_desc_stats_request */
    -1,   /* 46: of_bsn_gentable_entry_add */
    -1,   /* 47: of_bsn_gentable_entry_delete */
    -1,   /* 48: of_bsn_gentable_entry_desc_stats_reply */
    -1,   /* 49: of_bsn_gentable_entry_desc_stats_request */
    -1,   /* 50: of_bsn_gentable_entry_stats_reply */
    -1,   /* 51: of_bsn_gentable_entry_stats_request */
    -1,   /* 52: of_bsn_gentable_set_buckets_size */
    -1,   /* 53: of_bsn_gentable_stats_reply */
    -1,   /* 54: of_bsn_gentable_stats_request */
    16,   /* 55: of_bsn_get_interfaces_reply */
    16,   /* 56: of_bsn_get_interfaces_request */
    -1,   /* 57: of_bsn_get_ip_mask_reply */
    -1,   /* 58: of_bsn_get_ip_mask_request */
    -1,   /* 59: of_bsn_get_l2_table_reply */
    -1,   /* 60: of_bsn_get_l2_table_request */
    20,   /* 61: of_bsn_get_mirroring_reply */
    20,   /* 62: of_bsn_get_mirroring_request */
    -1,   /* 63: of_bsn_get_switch_pipeline_reply */
    -1,   /* 64: of_bsn_get_switch_pipeline_request */
    16,   /* 65: of_bsn_header */
    -1,   /* 66: of_bsn_hybrid_get_reply */
    -1,   /* 67: of_bsn_hybrid_get_request */
    -1,   /* 68: of_bsn_image_desc_stats_reply */
    -1,   /* 69: of_bsn_image_desc_stats_request */
    -1,   /* 70: of_bsn_lacp_convergence_notif */
    -1,   /* 71: of_bsn_lacp_stats_reply */
    -1,   /* 72: of_bsn_lacp_stats_request */
    -1,   /* 73: of_bsn_log */
    -1,   /* 74: of_bsn_lua_command_reply */
    -1,   /* 75: of_bsn_lua_command_request */
    -1,   /* 76: of_bsn_lua_notification */
    -1,   /* 77: of_bsn_lua_upload */
    25,   /* 78: of_bsn_pdu_rx_reply */
    28,   /* 79: of_bsn_pdu_rx_request */
    21,   /* 80: of_bsn_pdu_rx_timeout */
    25,   /* 81: of_bsn_pdu_tx_reply */
    28,   /* 82: of_bsn_pdu_tx_request */
    -1,   /* 83: of_bsn_port_counter_stats_reply */
    -1,   /* 84: of_bsn_port_counter_stats_request */
    -1,   /* 85: of_bsn_role_status */
    -1,   /* 86: of_bsn_set_aux_cxns_reply */
    -1,   /* 87: of_bsn_set_aux_cxns_request */
    -1,   /* 88: of_bsn_set_ip_mask */
    -1,   /* 89: of_bsn_set_l2_table_reply */
    -1,   /* 90: of_bsn_set_l2_table_request */
    -1,   /* 91: of_bsn_set_lacp_reply */
    -1,   /* 92: of_bsn_set_lacp_request */
    20,   /* 93: of_bsn_set_mirroring */
    20,   /* 94: of_bsn_set_pktin_suppression_reply */
    32,   /* 95: of_bsn_set_pktin_suppression_request */
    -1,   /* 96: of_bsn_set_switch_pipeline_reply */
    -1,   /* 97: of_bsn_set_switch_pipeline_request */
    -1,   /* 98: of_bsn_shell_command */
    -1,   /* 99: of_bsn_shell_output */
    -1,   /* 100: of_bsn_shell_status */
    24,   /* 101: of_bsn_stats_reply */
    24,   /* 102: of_bsn_stats_request */
    -1,   /* 103: of_bsn_switch_pipeline_stats_reply */
    -1,   /* 104: of_bsn_switch_pipeline_stats_request */
    -1,   /* 105: of_bsn_table_checksum_stats_reply */
    -1,   /* 106: of_bsn_table_checksum_stats_request */
    -1,   /* 107: of_bsn_table_set_buckets_size */
    -1,   /* 108: of_bsn_takeover */
    -1,   /* 109: of_bsn_time_reply */
    -1,   /* 110: of_bsn_time_request */
    24,   /* 111: of_bsn_virtual_port_create_reply */
    20,   /* 112: of_bsn_virtual_port_create_request */
    20,   /* 113: of_bsn_virtual_port_remove_reply */
    20,   /* 114: of_bsn_virtual_port_remove_request */
    -1,   /* 115: of_bsn_vlan_counter_clear */
    -1,   /* 116: of_bsn_vlan_counter_stats_reply */
    -1,   /* 117: of_bsn_vlan_counter_stats_request */
    -1,   /* 118: of_bsn_vrf_counter_stats_reply */
    -1,   /* 119: of_bsn_vrf_counter_stats_request */
    -1,   /* 120: of_bundle_add_msg */
    -1,   /* 121: of_bundle_ctrl_msg */
    -1,   /* 122: of_bundle_failed_error_msg */
    1072, /* 123: of_desc_stats_reply */
    16,   /* 124: of_desc_stats_request */
    8,    /* 125: of_echo_reply */
    8,    /* 126: of_echo_request */
    10,   /* 127: of_error_msg */
    12,   /* 128: of_experimenter */
    -1,   /* 129: of_experimenter_error_msg */
    24,   /* 130: of_experimenter_stats_reply */
    24,   /* 131: of_experimenter_stats_request */
    32,   /* 132: of_features_reply */
    8,    /* 133: of_features_request */
    136,  /* 134: of_flow_add */
    136,  /* 135: of_flow_delete */
    136,  /* 136: of_flow_delete_strict */
    136,  /* 137: of_flow_mod */
    12,   /* 138: of_flow_mod_failed_error_msg */
    136,  /* 139: of_flow_modify */
    136,  /* 140: of_flow_modify_strict */
    -1,   /* 141: of_flow_monitor_failed_error_msg */
    136,  /* 142: of_flow_removed */
    16,   /* 143: of_flow_stats_reply */
    136,  /* 144: of_flow_stats_request */
    12,   /* 145: of_get_config_reply */
    8,    /* 146: of_get_config_request */
    16,   /* 147: of_group_add */
    16,   /* 148: of_group_delete */
    16,   /* 149: of_group_desc_stats_reply */
    16,   /* 150: of_group_desc_stats_request */
    -1,   /* 151: of_group_features_stats_reply */
    -1,   /* 152: of_group_features_stats_request */
    16,   /* 153: of_group_mod */
    12,   /* 154: of_group_mod_failed_error_msg */
    16,   /* 155: of_group_modify */
    16,   /* 156: of_group_stats_reply */
    24,   /* 157: of_group_stats_request */
    8,    /* 158: of_header */
    8,    /* 159: of_hello */
    12,   /* 160: of_hello_failed_error_msg */
    -1,   /* 161: of_meter_config_stats_reply */
    -1,   /* 162: of_meter_config_stats_request */
    -1,   /* 163: of_meter_features_stats_reply */
    -1,   /* 164: of_meter_features_stats_request */
    -1,   /* 165: of_meter_mod */
    -1,   /* 166: of_meter_mod_failed_error_msg */
    -1,   /* 167: of_meter_stats_reply */
    -1,   /* 168: of_meter_stats_request */
    -1,   /* 169: of_nicira_controller_role_reply */
    -1,   /* 170: of_nicira_controller_role_request */
    16,   /* 171: of_nicira_header */
    24,   /* 172: of_packet_in */
    24,   /* 173: of_packet_out */
    -1,   /* 174: of_port_desc_stats_reply */
    -1,   /* 175: of_port_desc_stats_request */
    40,   /* 176: of_port_mod */
    12,   /* 177: of_port_mod_failed_error_msg */
    16,   /* 178: of_port_stats_reply */
    24,   /* 179: of_port_stats_request */
    80,   /* 180: of_port_status */
    -1,   /* 181: of_queue_desc_stats_reply */
    -1,   /* 182: of_queue_desc_stats_request */
    16,   /* 183: of_queue_get_config_reply */
    16,   /* 184: of_queue_get_config_request */
    12,   /* 185: of_queue_op_failed_error_msg */
    16,   /* 186: of_queue_stats_reply */
    24,   /* 187: of_queue_stats_request */
    -1,   /* 188: of_requestforward */
    -1,   /* 189: of_role_reply */
    -1,   /* 190: of_role_request */
    -1,   /* 191: of_role_request_failed_error_msg */
    -1,   /* 192: of_role_status */
    12,   /* 193: of_set_config */
    16,   /* 194: of_stats_reply */
    16,   /* 195: of_stats_request */
    12,   /* 196: of_switch_config_failed_error_msg */
    -1,   /* 197: of_table_desc_stats_reply */
    -1,   /* 198: of_table_desc_stats_request */
    -1,   /* 199: of_table_features_failed_error_msg */
    -1,   /* 200: of_table_features_stats_reply */
    -1,   /* 201: of_table_features_stats_request */
    16,   /* 202: of_table_mod */
    12,   /* 203: of_table_mod_failed_error_msg */
    16,   /* 204: of_table_stats_reply */
    16,   /* 205: of_table_stats_request */
    -1,   /* 206: of_table_status */
    8,    /* 207: of_action */
    16,   /* 208: of_action_bsn */
    28,   /* 209: of_action_bsn_checksum */
    -1,   /* 210: of_action_bsn_gentable */
    24,   /* 211: of_action_bsn_mirror */
    16,   /* 212: of_action_bsn_set_tunnel_dst */
    8,    /* 213: of_action_copy_ttl_in */
    8,    /* 214: of_action_copy_ttl_out */
    8,    /* 215: of_action_dec_mpls_ttl */
    8,    /* 216: of_action_dec_nw_ttl */
    -1,   /* 217: of_action_enqueue */
    8,    /* 218: of_action_experimenter */
    8,    /* 219: of_action_group */
    -1,   /* 220: of_action_id */
    -1,   /* 221: of_action_id_bsn */
    -1,   /* 222: of_action_id_bsn_checksum */
    -1,   /* 223: of_action_id_bsn_gentable */
    -1,   /* 224: of_action_id_bsn_mirror */
    -1,   /* 225: of_action_id_bsn_set_tunnel_dst */
    -1,   /* 226: of_action_id_copy_ttl_in */
    -1,   /* 227: of_action_id_copy_ttl_out */
    -1,   /* 228: of_action_id_dec_mpls_ttl */
    -1,   /* 229: of_action_id_dec_nw_ttl */
    -1,   /* 230: of_action_id_experimenter */
    -1,   /* 231: of_action_id_group */
    -1,   /* 232: of_action_id_nicira */
    -1,   /* 233: of_action_id_nicira_dec_ttl */
    -1,   /* 234: of_action_id_output */
    -1,   /* 235: of_action_id_pop_mpls */
    -1,   /* 236: of_action_id_pop_pbb */
    -1,   /* 237: of_action_id_pop_vlan */
    -1,   /* 238: of_action_id_push_mpls */
    -1,   /* 239: of_action_id_push_pbb */
    -1,   /* 240: of_action_id_push_vlan */
    -1,   /* 241: of_action_id_set_field */
    -1,   /* 242: of_action_id_set_mpls_ttl */
    -1,   /* 243: of_action_id_set_nw_ttl */
    -1,   /* 244: of_action_id_set_queue */
    16,   /* 245: of_action_nicira */
    16,   /* 246: of_action_nicira_dec_ttl */
    16,   /* 247: of_action_output */
    8,    /* 248: of_action_pop_mpls */
    -1,   /* 249: of_action_pop_pbb */
    8,    /* 250: of_action_pop_vlan */
    8,    /* 251: of_action_push_mpls */
    -1,   /* 252: of_action_push_pbb */
    8,    /* 253: of_action_push_vlan */
    16,   /* 254: of_action_set_dl_dst */
    16,   /* 255: of_action_set_dl_src */
    -1,   /* 256: of_action_set_field */
    8,    /* 257: of_action_set_mpls_label */
    8,    /* 258: of_action_set_mpls_tc */
    8,    /* 259: of_action_set_mpls_ttl */
    8,    /* 260: of_action_set_nw_dst */
    8,    /* 261: of_action_set_nw_ecn */
    8,    /* 262: of_action_set_nw_src */
    8,    /* 263: of_action_set_nw_tos */
    8,    /* 264: of_action_set_nw_ttl */
    8,    /* 265: of_action_set_queue */
    8,    /* 266: of_action_set_tp_dst */
    8,    /* 267: of_action_set_tp_src */
    8,    /* 268: of_action_set_vlan_pcp */
    8,    /* 269: of_action_set_vlan_vid */
    -1,   /* 270: of_action_strip_vlan */
    -1,   /* 271: of_async_config_prop */
    -1,   /* 272: of_async_config_prop_experimenter_master */
    -1,   /* 273: of_async_config_prop_experimenter_slave */
    -1,   /* 274: of_async_config_prop_flow_removed_master */
    -1,   /* 275: of_async_config_prop_flow_removed_slave */
    -1,   /* 276: of_async_config_prop_packet_in_master */
    -1,   /* 277: of_async_config_prop_packet_in_slave */
    -1,   /* 278: of_async_config_prop_port_status_master */
    -1,   /* 279: of_async_config_prop_port_status_slave */
    -1,   /* 280: of_async_config_prop_requestforward_master */
    -1,   /* 281: of_async_config_prop_requestforward_slave */
    -1,   /* 282: of_async_config_prop_role_status_master */
    -1,   /* 283: of_async_config_prop_role_status_slave */
    -1,   /* 284: of_async_config_prop_table_status_master */
    -1,   /* 285: of_async_config_prop_table_status_slave */
    -1,   /* 286: of_bsn_controller_connection */
    -1,   /* 287: of_bsn_debug_counter_desc_stats_entry */
    -1,   /* 288: of_bsn_debug_counter_stats_entry */
    -1,   /* 289: of_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 290: of_bsn_generic_stats_entry */
    -1,   /* 291: of_bsn_gentable_bucket_stats_entry */
    -1,   /* 292: of_bsn_gentable_desc_stats_entry */
    -1,   /* 293: of_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 294: of_bsn_gentable_entry_stats_entry */
    -1,   /* 295: of_bsn_gentable_stats_entry */
    32,   /* 296: of_bsn_interface */
    -1,   /* 297: of_bsn_lacp_stats_entry */
    -1,   /* 298: of_bsn_port_counter_stats_entry */
    -1,   /* 299: of_bsn_switch_pipeline_stats_entry */
    -1,   /* 300: of_bsn_table_checksum_stats_entry */
    -1,   /* 301: of_bsn_tlv */
    -1,   /* 302: of_bsn_tlv_actor_key */
    -1,   /* 303: of_bsn_tlv_actor_port_num */
    -1,   /* 304: of_bsn_tlv_actor_port_priority */
    -1,   /* 305: of_bsn_tlv_actor_state */
    -1,   /* 306: of_bsn_tlv_actor_system_mac */
    -1,   /* 307: of_bsn_tlv_actor_system_priority */
    -1,   /* 308: of_bsn_tlv_anchor */
    -1,   /* 309: of_bsn_tlv_broadcast_query_timeout */
    -1,   /* 310: of_bsn_tlv_broadcast_rate */
    -1,   /* 311: of_bsn_tlv_bucket */
    -1,   /* 312: of_bsn_tlv_circuit_id */
    -1,   /* 313: of_bsn_tlv_convergence_status */
    -1,   /* 314: of_bsn_tlv_crc_enabled */
    -1,   /* 315: of_bsn_tlv_data */
    -1,   /* 316: of_bsn_tlv_decap */
    -1,   /* 317: of_bsn_tlv_eth_dst */
    -1,   /* 318: of_bsn_tlv_eth_src */
    -1,   /* 319: of_bsn_tlv_external_gateway_ip */
    -1,   /* 320: of_bsn_tlv_external_gateway_mac */
    -1,   /* 321: of_bsn_tlv_external_ip */
    -1,   /* 322: of_bsn_tlv_external_mac */
    -1,   /* 323: of_bsn_tlv_external_netmask */
    -1,   /* 324: of_bsn_tlv_generation_id */
    -1,   /* 325: of_bsn_tlv_header_size */
    -1,   /* 326: of_bsn_tlv_icmp_code */
    -1,   /* 327: of_bsn_tlv_icmp_id */
    -1,   /* 328: of_bsn_tlv_icmp_type */
    -1,   /* 329: of_bsn_tlv_idle_notification */
    -1,   /* 330: of_bsn_tlv_idle_time */
    -1,   /* 331: of_bsn_tlv_idle_timeout */
    -1,   /* 332: of_bsn_tlv_igmp_snooping */
    -1,   /* 333: of_bsn_tlv_internal_gateway_mac */
    -1,   /* 334: of_bsn_tlv_internal_mac */
    -1,   /* 335: of_bsn_tlv_interval */
    -1,   /* 336: of_bsn_tlv_ip_proto */
    -1,   /* 337: of_bsn_tlv_ipv4 */
    -1,   /* 338: of_bsn_tlv_ipv4_dst */
    -1,   /* 339: of_bsn_tlv_ipv4_netmask */
    -1,   /* 340: of_bsn_tlv_ipv4_src */
    -1,   /* 341: of_bsn_tlv_ipv6 */
    -1,   /* 342: of_bsn_tlv_known_multicast_rate */
    -1,   /* 343: of_bsn_tlv_l2_multicast_lookup */
    -1,   /* 344: of_bsn_tlv_mac */
    -1,   /* 345: of_bsn_tlv_mac_mask */
    -1,   /* 346: of_bsn_tlv_mcg_type_vxlan */
    -1,   /* 347: of_bsn_tlv_miss_packets */
    -1,   /* 348: of_bsn_tlv_mpls_control_word */
    -1,   /* 349: of_bsn_tlv_mpls_label */
    -1,   /* 350: of_bsn_tlv_mpls_sequenced */
    -1,   /* 351: of_bsn_tlv_multicast_interface_id */
    -1,   /* 352: of_bsn_tlv_name */
    -1,   /* 353: of_bsn_tlv_negate */
    -1,   /* 354: of_bsn_tlv_nexthop_type_vxlan */
    -1,   /* 355: of_bsn_tlv_offset */
    -1,   /* 356: of_bsn_tlv_partner_key */
    -1,   /* 357: of_bsn_tlv_partner_port_num */
    -1,   /* 358: of_bsn_tlv_partner_port_priority */
    -1,   /* 359: of_bsn_tlv_partner_state */
    -1,   /* 360: of_bsn_tlv_partner_system_mac */
    -1,   /* 361: of_bsn_tlv_partner_system_priority */
    -1,   /* 362: of_bsn_tlv_port */
    -1,   /* 363: of_bsn_tlv_port_vxlan_mode */
    -1,   /* 364: of_bsn_tlv_priority */
    -1,   /* 365: of_bsn_tlv_queue_id */
    -1,   /* 366: of_bsn_tlv_queue_weight */
    -1,   /* 367: of_bsn_tlv_rate_unit */
    -1,   /* 368: of_bsn_tlv_reference */
    -1,   /* 369: of_bsn_tlv_reply_packets */
    -1,   /* 370: of_bsn_tlv_request_packets */
    -1,   /* 371: of_bsn_tlv_rx_bytes */
    -1,   /* 372: of_bsn_tlv_rx_packets */
    -1,   /* 373: of_bsn_tlv_sampling_rate */
    -1,   /* 374: of_bsn_tlv_set_loopback_mode */
    -1,   /* 375: of_bsn_tlv_status */
    -1,   /* 376: of_bsn_tlv_strip_mpls_l2_on_ingress */
    -1,   /* 377: of_bsn_tlv_strip_mpls_l3_on_ingress */
    -1,   /* 378: of_bsn_tlv_strip_vlan_on_egress */
    -1,   /* 379: of_bsn_tlv_sub_agent_id */
    -1,   /* 380: of_bsn_tlv_tcp_dst */
    -1,   /* 381: of_bsn_tlv_tcp_src */
    -1,   /* 382: of_bsn_tlv_tx_bytes */
    -1,   /* 383: of_bsn_tlv_tx_packets */
    -1,   /* 384: of_bsn_tlv_udf_anchor */
    -1,   /* 385: of_bsn_tlv_udf_id */
    -1,   /* 386: of_bsn_tlv_udf_length */
    -1,   /* 387: of_bsn_tlv_udf_offset */
    -1,   /* 388: of_bsn_tlv_udp_dst */
    -1,   /* 389: of_bsn_tlv_udp_src */
    -1,   /* 390: of_bsn_tlv_unicast_query_timeout */
    -1,   /* 391: of_bsn_tlv_unicast_rate */
    -1,   /* 392: of_bsn_tlv_unknown_multicast_rate */
    -1,   /* 393: of_bsn_tlv_use_packet_state */
    -1,   /* 394: of_bsn_tlv_vfi */
    -1,   /* 395: of_bsn_tlv_vlan_mac_list */
    -1,   /* 396: of_bsn_tlv_vlan_pcp */
    -1,   /* 397: of_bsn_tlv_vlan_vid */
    -1,   /* 398: of_bsn_tlv_vlan_vid_mask */
    -1,   /* 399: of_bsn_tlv_vni */
    -1,   /* 400: of_bsn_tlv_vrf */
    -1,   /* 401: of_bsn_vlan_counter_stats_entry */
    -1,   /* 402: of_bsn_vlan_mac */
    4,    /* 403: of_bsn_vport */
    64,   /* 404: of_bsn_vport_l2gre */
    32,   /* 405: of_bsn_vport_q_in_q */
    -1,   /* 406: of_bsn_vrf_counter_stats_entry */
    16,   /* 407: of_bucket */
    16,   /* 408: of_bucket_counter */
    -1,   /* 409: of_bundle_prop */
    -1,   /* 410: of_bundle_prop_experimenter */
    136,  /* 411: of_flow_stats_entry */
    8,    /* 412: of_group_desc_stats_entry */
    32,   /* 413: of_group_stats_entry */
    -1,   /* 414: of_hello_elem */
    -1,   /* 415: of_hello_elem_versionbitmap */
    8,    /* 416: of_instruction */
    8,    /* 417: of_instruction_apply_actions */
    -1,   /* 418: of_instruction_bsn */
    -1,   /* 419: of_instruction_bsn_arp_offload */
    -1,   /* 420: of_instruction_bsn_auto_negotiation */
    -1,   /* 421: of_instruction_bsn_deny */
    -1,   /* 422: of_instruction_bsn_dhcp_offload */
    -1,   /* 423: of_instruction_bsn_disable_l3 */
    -1,   /* 424: of_instruction_bsn_disable_split_horizon_check */
    -1,   /* 425: of_instruction_bsn_disable_src_mac_check */
    -1,   /* 426: of_instruction_bsn_disable_vlan_counters */
    -1,   /* 427: of_instruction_bsn_internal_priority */
    -1,   /* 428: of_instruction_bsn_packet_of_death */
    -1,   /* 429: of_instruction_bsn_permit */
    -1,   /* 430: of_instruction_bsn_prioritize_pdus */
    -1,   /* 431: of_instruction_bsn_require_vlan_xlate */
    -1,   /* 432: of_instruction_bsn_span_destination */
    8,    /* 433: of_instruction_clear_actions */
    8,    /* 434: of_instruction_experimenter */
    8,    /* 435: of_instruction_goto_table */
    -1,   /* 436: of_instruction_id */
    -1,   /* 437: of_instruction_id_apply_actions */
    -1,   /* 438: of_instruction_id_bsn */
    -1,   /* 439: of_instruction_id_bsn_arp_offload */
    -1,   /* 440: of_instruction_id_bsn_auto_negotiation */
    -1,   /* 441: of_instruction_id_bsn_deny */
    -1,   /* 442: of_instruction_id_bsn_dhcp_offload */
    -1,   /* 443: of_instruction_id_bsn_disable_l3 */
    -1,   /* 444: of_instruction_id_bsn_disable_split_horizon_check */
    -1,   /* 445: of_instruction_id_bsn_disable_src_mac_check */
    -1,   /* 446: of_instruction_id_bsn_disable_vlan_counters */
    -1,   /* 447: of_instruction_id_bsn_internal_priority */
    -1,   /* 448: of_instruction_id_bsn_packet_of_death */
    -1,   /* 449: of_instruction_id_bsn_permit */
    -1,   /* 450: of_instruction_id_bsn_prioritize_pdus */
    -1,   /* 451: of_instruction_id_bsn_require_vlan_xlate */
    -1,   /* 452: of_instruction_id_bsn_span_destination */
    -1,   /* 453: of_instruction_id_clear_actions */
    -1,   /* 454: of_instruction_id_experimenter */
    -1,   /* 455: of_instruction_id_goto_table */
    -1,   /* 456: of_instruction_id_meter */
    -1,   /* 457: of_instruction_id_write_actions */
    -1,   /* 458: of_instruction_id_write_metadata */
    -1,   /* 459: of_instruction_meter */
    8,    /* 460: of_instruction_write_actions */
    24,   /* 461: of_instruction_write_metadata */
    -1,   /* 462: of_match_v1 */
    88,   /* 463: of_match_v2 */
    -1,   /* 464: of_match_v3 */
    -1,   /* 465: of_meter_band */
    -1,   /* 466: of_meter_band_drop */
    -1,   /* 467: of_meter_band_dscp_remark */
    -1,   /* 468: of_meter_band_experimenter */
    -1,   /* 469: of_meter_band_stats */
    -1,   /* 470: of_meter_config */
    -1,   /* 471: of_meter_features */
    -1,   /* 472: of_meter_stats */
    -1,   /* 473: of_oxm */
    -1,   /* 474: of_oxm_arp_op */
    -1,   /* 475: of_oxm_arp_op_masked */
    -1,   /* 476: of_oxm_arp_sha */
    -1,   /* 477: of_oxm_arp_sha_masked */
    -1,   /* 478: of_oxm_arp_spa */
    -1,   /* 479: of_oxm_arp_spa_masked */
    -1,   /* 480: of_oxm_arp_tha */
    -1,   /* 481: of_oxm_arp_tha_masked */
    -1,   /* 482: of_oxm_arp_tpa */
    -1,   /* 483: of_oxm_arp_tpa_masked */
    -1,   /* 484: of_oxm_bsn_egr_port_group_id */
    -1,   /* 485: of_oxm_bsn_egr_port_group_id_masked */
    -1,   /* 486: of_oxm_bsn_global_vrf_allowed */
    -1,   /* 487: of_oxm_bsn_global_vrf_allowed_masked */
    -1,   /* 488: of_oxm_bsn_in_ports_128 */
    -1,   /* 489: of_oxm_bsn_in_ports_128_masked */
    -1,   /* 490: of_oxm_bsn_in_ports_512 */
    -1,   /* 491: of_oxm_bsn_in_ports_512_masked */
    -1,   /* 492: of_oxm_bsn_ingress_port_group_id */
    -1,   /* 493: of_oxm_bsn_ingress_port_group_id_masked */
    -1,   /* 494: of_oxm_bsn_inner_eth_dst */
    -1,   /* 495: of_oxm_bsn_inner_eth_dst_masked */
    -1,   /* 496: of_oxm_bsn_inner_eth_src */
    -1,   /* 497: of_oxm_bsn_inner_eth_src_masked */
    -1,   /* 498: of_oxm_bsn_inner_vlan_vid */
    -1,   /* 499: of_oxm_bsn_inner_vlan_vid_masked */
    -1,   /* 500: of_oxm_bsn_l2_cache_hit */
    -1,   /* 501: of_oxm_bsn_l2_cache_hit_masked */
    -1,   /* 502: of_oxm_bsn_l3_dst_class_id */
    -1,   /* 503: of_oxm_bsn_l3_dst_class_id_masked */
    -1,   /* 504: of_oxm_bsn_l3_interface_class_id */
    -1,   /* 505: of_oxm_bsn_l3_interface_class_id_masked */
    -1,   /* 506: of_oxm_bsn_l3_src_class_id */
    -1,   /* 507: of_oxm_bsn_l3_src_class_id_masked */
    -1,   /* 508: of_oxm_bsn_lag_id */
    -1,   /* 509: of_oxm_bsn_lag_id_masked */
    -1,   /* 510: of_oxm_bsn_tcp_flags */
    -1,   /* 511: of_oxm_bsn_tcp_flags_masked */
    -1,   /* 512: of_oxm_bsn_udf0 */
    -1,   /* 513: of_oxm_bsn_udf0_masked */
    -1,   /* 514: of_oxm_bsn_udf1 */
    -1,   /* 515: of_oxm_bsn_udf1_masked */
    -1,   /* 516: of_oxm_bsn_udf2 */
    -1,   /* 517: of_oxm_bsn_udf2_masked */
    -1,   /* 518: of_oxm_bsn_udf3 */
    -1,   /* 519: of_oxm_bsn_udf3_masked */
    -1,   /* 520: of_oxm_bsn_udf4 */
    -1,   /* 521: of_oxm_bsn_udf4_masked */
    -1,   /* 522: of_oxm_bsn_udf5 */
    -1,   /* 523: of_oxm_bsn_udf5_masked */
    -1,   /* 524: of_oxm_bsn_udf6 */
    -1,   /* 525: of_oxm_bsn_udf6_masked */
    -1,   /* 526: of_oxm_bsn_udf7 */
    -1,   /* 527: of_oxm_bsn_udf7_masked */
    -1,   /* 528: of_oxm_bsn_vlan_xlate_port_group_id */
    -1,   /* 529: of_oxm_bsn_vlan_xlate_port_group_id_masked */
    -1,   /* 530: of_oxm_bsn_vrf */
    -1,   /* 531: of_oxm_bsn_vrf_masked */
    -1,   /* 532: of_oxm_bsn_vxlan_network_id */
    -1,   /* 533: of_oxm_bsn_vxlan_network_id_masked */
    -1,   /* 534: of_oxm_eth_dst */
    -1,   /* 535: of_oxm_eth_dst_masked */
    -1,   /* 536: of_oxm_eth_src */
    -1,   /* 537: of_oxm_eth_src_masked */
    -1,   /* 538: of_oxm_eth_type */
    -1,   /* 539: of_oxm_eth_type_masked */
    -1,   /* 540: of_oxm_icmpv4_code */
    -1,   /* 541: of_oxm_icmpv4_code_masked */
    -1,   /* 542: of_oxm_icmpv4_type */
    -1,   /* 543: of_oxm_icmpv4_type_masked */
    -1,   /* 544: of_oxm_icmpv6_code */
    -1,   /* 545: of_oxm_icmpv6_code_masked */
    -1,   /* 546: of_oxm_icmpv6_type */
    -1,   /* 547: of_oxm_icmpv6_type_masked */
    -1,   /* 548: of_oxm_in_phy_port */
    -1,   /* 549: of_oxm_in_phy_port_masked */
    -1,   /* 550: of_oxm_in_port */
    -1,   /* 551: of_oxm_in_port_masked */
    -1,   /* 552: of_oxm_ip_dscp */
    -1,   /* 553: of_oxm_ip_dscp_masked */
    -1,   /* 554: of_oxm_ip_ecn */
    -1,   /* 555: of_oxm_ip_ecn_masked */
    -1,   /* 556: of_oxm_ip_proto */
    -1,   /* 557: of_oxm_ip_proto_masked */
    -1,   /* 558: of_oxm_ipv4_dst */
    -1,   /* 559: of_oxm_ipv4_dst_masked */
    -1,   /* 560: of_oxm_ipv4_src */
    -1,   /* 561: of_oxm_ipv4_src_masked */
    -1,   /* 562: of_oxm_ipv6_dst */
    -1,   /* 563: of_oxm_ipv6_dst_masked */
    -1,   /* 564: of_oxm_ipv6_exthdr */
    -1,   /* 565: of_oxm_ipv6_exthdr_masked */
    -1,   /* 566: of_oxm_ipv6_flabel */
    -1,   /* 567: of_oxm_ipv6_flabel_masked */
    -1,   /* 568: of_oxm_ipv6_nd_sll */
    -1,   /* 569: of_oxm_ipv6_nd_sll_masked */
    -1,   /* 570: of_oxm_ipv6_nd_target */
    -1,   /* 571: of_oxm_ipv6_nd_target_masked */
    -1,   /* 572: of_oxm_ipv6_nd_tll */
    -1,   /* 573: of_oxm_ipv6_nd_tll_masked */
    -1,   /* 574: of_oxm_ipv6_src */
    -1,   /* 575: of_oxm_ipv6_src_masked */
    -1,   /* 576: of_oxm_metadata */
    -1,   /* 577: of_oxm_metadata_masked */
    -1,   /* 578: of_oxm_mpls_bos */
    -1,   /* 579: of_oxm_mpls_bos_masked */
    -1,   /* 580: of_oxm_mpls_label */
    -1,   /* 581: of_oxm_mpls_label_masked */
    -1,   /* 582: of_oxm_mpls_tc */
    -1,   /* 583: of_oxm_mpls_tc_masked */
    -1,   /* 584: of_oxm_pbb_uca */
    -1,   /* 585: of_oxm_pbb_uca_masked */
    -1,   /* 586: of_oxm_sctp_dst */
    -1,   /* 587: of_oxm_sctp_dst_masked */
    -1,   /* 588: of_oxm_sctp_src */
    -1,   /* 589: of_oxm_sctp_src_masked */
    -1,   /* 590: of_oxm_tcp_dst */
    -1,   /* 591: of_oxm_tcp_dst_masked */
    -1,   /* 592: of_oxm_tcp_src */
    -1,   /* 593: of_oxm_tcp_src_masked */
    -1,   /* 594: of_oxm_tunnel_id */
    -1,   /* 595: of_oxm_tunnel_id_masked */
    -1,   /* 596: of_oxm_tunnel_ipv4_dst */
    -1,   /* 597: of_oxm_tunnel_ipv4_dst_masked */
    -1,   /* 598: of_oxm_tunnel_ipv4_src */
    -1,   /* 599: of_oxm_tunnel_ipv4_src_masked */
    -1,   /* 600: of_oxm_udp_dst */
    -1,   /* 601: of_oxm_udp_dst_masked */
    -1,   /* 602: of_oxm_udp_src */
    -1,   /* 603: of_oxm_udp_src_masked */
    -1,   /* 604: of_oxm_vlan_pcp */
    -1,   /* 605: of_oxm_vlan_pcp_masked */
    -1,   /* 606: of_oxm_vlan_vid */
    -1,   /* 607: of_oxm_vlan_vid_masked */
    8,    /* 608: of_packet_queue */
    64,   /* 609: of_port_desc */
    -1,   /* 610: of_port_desc_prop */
    -1,   /* 611: of_port_desc_prop_bsn */
    -1,   /* 612: of_port_desc_prop_bsn_generation_id */
    -1,   /* 613: of_port_desc_prop_bsn_uplink */
    -1,   /* 614: of_port_desc_prop_ethernet */
    -1,   /* 615: of_port_desc_prop_experimenter */
    -1,   /* 616: of_port_desc_prop_optical */
    -1,   /* 617: of_port_mod_prop */
    -1,   /* 618: of_port_mod_prop_ethernet */
    -1,   /* 619: of_port_mod_prop_experimenter */
    -1,   /* 620: of_port_mod_prop_optical */
    104,  /* 621: of_port_stats_entry */
    -1,   /* 622: of_port_stats_prop */
    -1,   /* 623: of_port_stats_prop_ethernet */
    -1,   /* 624: of_port_stats_prop_experimenter */
    -1,   /* 625: of_port_stats_prop_optical */
    -1,   /* 626: of_queue_desc */
    -1,   /* 627: of_queue_desc_prop */
    -1,   /* 628: of_queue_desc_prop_experimenter */
    -1,   /* 629: of_queue_desc_prop_max_rate */
    -1,   /* 630: of_queue_desc_prop_min_rate */
    8,    /* 631: of_queue_prop */
    -1,   /* 632: of_queue_prop_experimenter */
    -1,   /* 633: of_queue_prop_max_rate */
    16,   /* 634: of_queue_prop_min_rate */
    32,   /* 635: of_queue_stats_entry */
    -1,   /* 636: of_queue_stats_prop */
    -1,   /* 637: of_queue_stats_prop_experimenter */
    -1,   /* 638: of_role_prop */
    -1,   /* 639: of_role_prop_experimenter */
    -1,   /* 640: of_table_desc */
    -1,   /* 641: of_table_feature_prop */
    -1,   /* 642: of_table_feature_prop_apply_actions */
    -1,   /* 643: of_table_feature_prop_apply_actions_miss */
    -1,   /* 644: of_table_feature_prop_apply_setfield */
    -1,   /* 645: of_table_feature_prop_apply_setfield_miss */
    -1,   /* 646: of_table_feature_prop_experimenter */
    -1,   /* 647: of_table_feature_prop_experimenter_miss */
    -1,   /* 648: of_table_feature_prop_instructions */
    -1,   /* 649: of_table_feature_prop_instructions_miss */
    -1,   /* 650: of_table_feature_prop_match */
    -1,   /* 651: of_table_feature_prop_next_tables */
    -1,   /* 652: of_table_feature_prop_next_tables_miss */
    -1,   /* 653: of_table_feature_prop_table_sync_from */
    -1,   /* 654: of_table_feature_prop_wildcards */
    -1,   /* 655: of_table_feature_prop_write_actions */
    -1,   /* 656: of_table_feature_prop_write_actions_miss */
    -1,   /* 657: of_table_feature_prop_write_setfield */
    -1,   /* 658: of_table_feature_prop_write_setfield_miss */
    -1,   /* 659: of_table_features */
    -1,   /* 660: of_table_mod_prop */
    -1,   /* 661: of_table_mod_prop_eviction */
    -1,   /* 662: of_table_mod_prop_experimenter */
    -1,   /* 663: of_table_mod_prop_vacancy */
    88,   /* 664: of_table_stats_entry */
    -1,   /* 665: of_uint32 */
    -1,   /* 666: of_uint64 */
    -1,   /* 667: of_uint8 */
    0,    /* 668: of_list_action */
    -1,   /* 669: of_list_action_id */
    -1,   /* 670: of_list_async_config_prop */
    -1,   /* 671: of_list_bsn_controller_connection */
    -1,   /* 672: of_list_bsn_debug_counter_desc_stats_entry */
    -1,   /* 673: of_list_bsn_debug_counter_stats_entry */
    -1,   /* 674: of_list_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 675: of_list_bsn_generic_stats_entry */
    -1,   /* 676: of_list_bsn_gentable_bucket_stats_entry */
    -1,   /* 677: of_list_bsn_gentable_desc_stats_entry */
    -1,   /* 678: of_list_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 679: of_list_bsn_gentable_entry_stats_entry */
    -1,   /* 680: of_list_bsn_gentable_stats_entry */
    0,    /* 681: of_list_bsn_interface */
    -1,   /* 682: of_list_bsn_lacp_stats_entry */
    -1,   /* 683: of_list_bsn_port_counter_stats_entry */
    -1,   /* 684: of_list_bsn_switch_pipeline_stats_entry */
    -1,   /* 685: of_list_bsn_table_checksum_stats_entry */
    -1,   /* 686: of_list_bsn_tlv */
    -1,   /* 687: of_list_bsn_vlan_counter_stats_entry */
    -1,   /* 688: of_list_bsn_vlan_mac */
    -1,   /* 689: of_list_bsn_vrf_counter_stats_entry */
    0,    /* 690: of_list_bucket */
    0,    /* 691: of_list_bucket_counter */
    -1,   /* 692: of_list_bundle_prop */
    0,    /* 693: of_list_flow_stats_entry */
    0,    /* 694: of_list_group_desc_stats_entry */
    0,    /* 695: of_list_group_stats_entry */
    -1,   /* 696: of_list_hello_elem */
    0,    /* 697: of_list_instruction */
    -1,   /* 698: of_list_instruction_id */
    -1,   /* 699: of_list_meter_band */
    -1,   /* 700: of_list_meter_band_stats */
    -1,   /* 701: of_list_meter_config */
    -1,   /* 702: of_list_meter_stats */
    -1,   /* 703: of_list_oxm */
    0,    /* 704: of_list_packet_queue */
    0,    /* 705: of_list_port_desc */
    -1,   /* 706: of_list_port_desc_prop */
    -1,   /* 707: of_list_port_mod_prop */
    0,    /* 708: of_list_port_stats_entry */
    -1,   /* 709: of_list_port_stats_prop */
    -1,   /* 710: of_list_queue_desc */
    -1,   /* 711: of_list_queue_desc_prop */
    0,    /* 712: of_list_queue_prop */
    0,    /* 713: of_list_queue_stats_entry */
    -1,   /* 714: of_list_queue_stats_prop */
    -1,   /* 715: of_list_role_prop */
    -1,   /* 716: of_list_table_desc */
    -1,   /* 717: of_list_table_feature_prop */
    -1,   /* 718: of_list_table_features */
    -1,   /* 719: of_list_table_mod_prop */
    0,    /* 720: of_list_table_stats_entry */
    -1,   /* 721: of_list_uint32 */
    -1,   /* 722: of_list_uint64 */
    -1    /* 723: of_list_uint8 */
};

static const int
of_object_fixed_len_v3[OF_OBJECT_COUNT] = {
    -1,   /* of_object is not instantiable */
    40,   /* 1: of_aggregate_stats_reply */
    56,   /* 2: of_aggregate_stats_request */
    -1,   /* 3: of_async_config_failed_error_msg */
    -1,   /* 4: of_async_get_reply */
    -1,   /* 5: of_async_get_request */
    -1,   /* 6: of_async_set */
    12,   /* 7: of_bad_action_error_msg */
    12,   /* 8: of_bad_instruction_error_msg */
    12,   /* 9: of_bad_match_error_msg */
    -1,   /* 10: of_bad_property_error_msg */
    12,   /* 11: of_bad_request_error_msg */
    8,    /* 12: of_barrier_reply */
    8,    /* 13: of_barrier_request */
    -1,   /* 14: of_bsn_arp_idle */
    -1,   /* 15: of_bsn_base_error */
    20,   /* 16: of_bsn_bw_clear_data_reply */
    16,   /* 17: of_bsn_bw_clear_data_request */
    20,   /* 18: of_bsn_bw_enable_get_reply */
    16,   /* 19: of_bsn_bw_enable_get_request */
    24,   /* 20: of_bsn_bw_enable_set_reply */
    20,   /* 21: of_bsn_bw_enable_set_request */
    -1,   /* 22: of_bsn_controller_connections_reply */
    -1,   /* 23: of_bsn_controller_connections_request */
    -1,   /* 24: of_bsn_debug_counter_desc_stats_reply */
    -1,   /* 25: of_bsn_debug_counter_desc_stats_request */
    -1,   /* 26: of_bsn_debug_counter_stats_reply */
    -1,   /* 27: of_bsn_debug_counter_stats_request */
    -1,   /* 28: of_bsn_error */
    -1,   /* 29: of_bsn_flow_checksum_bucket_stats_reply */
    -1,   /* 30: of_bsn_flow_checksum_bucket_stats_request */
    -1,   /* 31: of_bsn_flow_idle */
    -1,   /* 32: of_bsn_flow_idle_enable_get_reply */
    -1,   /* 33: of_bsn_flow_idle_enable_get_request */
    -1,   /* 34: of_bsn_flow_idle_enable_set_reply */
    -1,   /* 35: of_bsn_flow_idle_enable_set_request */
    -1,   /* 36: of_bsn_generic_async */
    -1,   /* 37: of_bsn_generic_command */
    -1,   /* 38: of_bsn_generic_stats_reply */
    -1,   /* 39: of_bsn_generic_stats_request */
    -1,   /* 40: of_bsn_gentable_bucket_stats_reply */
    -1,   /* 41: of_bsn_gentable_bucket_stats_request */
    -1,   /* 42: of_bsn_gentable_clear_reply */
    -1,   /* 43: of_bsn_gentable_clear_request */
    -1,   /* 44: of_bsn_gentable_desc_stats_reply */
    -1,   /* 45: of_bsn_gentable_desc_stats_request */
    -1,   /* 46: of_bsn_gentable_entry_add */
    -1,   /* 47: of_bsn_gentable_entry_delete */
    -1,   /* 48: of_bsn_gentable_entry_desc_stats_reply */
    -1,   /* 49: of_bsn_gentable_entry_desc_stats_request */
    -1,   /* 50: of_bsn_gentable_entry_stats_reply */
    -1,   /* 51: of_bsn_gentable_entry_stats_request */
    -1,   /* 52: of_bsn_gentable_set_buckets_size */
    -1,   /* 53: of_bsn_gentable_stats_reply */
    -1,   /* 54: of_bsn_gentable_stats_request */
    16,   /* 55: of_bsn_get_interfaces_reply */
    16,   /* 56: of_bsn_get_interfaces_request */
    -1,   /* 57: of_bsn_get_ip_mask_reply */
    -1,   /* 58: of_bsn_get_ip_mask_request */
    -1,   /* 59: of_bsn_get_l2_table_reply */
    -1,   /* 60: of_bsn_get_l2_table_request */
    20,   /* 61: of_bsn_get_mirroring_reply */
    20,   /* 62: of_bsn_get_mirroring_request */
    -1,   /* 63: of_bsn_get_switch_pipeline_reply */
    -1,   /* 64: of_bsn_get_switch_pipeline_request */
    16,   /* 65: of_bsn_header */
    -1,   /* 66: of_bsn_hybrid_get_reply */
    -1,   /* 67: of_bsn_hybrid_get_request */
    -1,   /* 68: of_bsn_image_desc_stats_reply */
    -1,   /* 69: of_bsn_image_desc_stats_request */
    -1,   /* 70: of_bsn_lacp_convergence_notif */
    -1,   /* 71: of_bsn_lacp_stats_reply */
    -1,   /* 72: of_bsn_lacp_stats_request */
    -1,   /* 73: of_bsn_log */
    -1,   /* 74: of_bsn_lua_command_reply */
    -1,   /* 75: of_bsn_lua_command_request */
    -1,   /* 76: of_bsn_lua_notification */
    -1,   /* 77: of_bsn_lua_upload */
    25,   /* 78: of_bsn_pdu_rx_reply */
    28,   /* 79: of_bsn_pdu_rx_request */
    21,   /* 80: of_bsn_pdu_rx_timeout */
    25,   /* 81: of_bsn_pdu_tx_reply */
    28,   /* 82: of_bsn_pdu_tx_request */
    -1,   /* 83: of_bsn_port_counter_stats_reply */
    -1,   /* 84: of_bsn_port_counter_stats_request */
    -1,   /* 85: of_bsn_role_status */
    -1,   /* 86: of_bsn_set_aux_cxns_reply */
    -1,   /* 87: of_bsn_set_aux_cxns_request */
    -1,   /* 88: of_bsn_set_ip_mask */
    -1,   /* 89: of_bsn_set_l2_table_reply */
    -1,   /* 90: of_bsn_set_l2_table_request */
    -1,   /* 91: of_bsn_set_lacp_reply */
    -1,   /* 92: of_bsn_set_lacp_request */
    20,   /* 93: of_bsn_set_mirroring */
    20,   /* 94: of_bsn_set_pktin_suppression_reply */
    32,   /* 95: of_bsn_set_pktin_suppression_request */
    -1,   /* 96: of_bsn_set_switch_pipeline_reply */
    -1,   /* 97: of_bsn_set_switch_pipeline_request */
    -1,   /* 98: of_bsn_shell_command */
    -1,   /* 99: of_bsn_shell_output */
    -1,   /* 100: of_bsn_shell_status */
    24,   /* 101: of_bsn_stats_reply */
    24,   /* 102: of_bsn_stats_request */
    -1,   /* 103: of_bsn_switch_pipeline_stats_reply */
    -1,   /* 104: of_bsn_switch_pipeline_stats_request */
    -1,   /* 105: of_bsn_table_checksum_stats_reply */
    -1,   /* 106: of_bsn_table_checksum_stats_request */
    -1,   /* 107: of_bsn_table_set_buckets_size */
    -1,   /* 108: of_bsn_takeover */
    -1,   /* 109: of_bsn_time_reply */
    -1,   /* 110: of_bsn_time_request */
    24,   /* 111: of_bsn_virtual_port_create_reply */
    20,   /* 112: of_bsn_virtual_port_create_request */
    20,   /* 113: of_bsn_virtual_port_remove_reply */
    20,   /* 114: of_bsn_virtual_port_remove_request */
    -1,   /* 115: of_bsn_vlan_counter_clear */
    -1,   /* 116: of_bsn_vlan_counter_stats_reply */
    -1,   /* 117: of_bsn_vlan_counter_stats_request */
    -1,   /* 118: of_bsn_vrf_counter_stats_reply */
    -1,   /* 119: of_bsn_vrf_counter_stats_request */
    -1,   /* 120: of_bundle_add_msg */
    -1,   /* 121: of_bundle_ctrl_msg */
    -1,   /* 122: of_bundle_failed_error_msg */
    1072, /* 123: of_desc_stats_reply */
    16,   /* 124: of_desc_stats_request */
    8,    /* 125: of_echo_reply */
    8,    /* 126: of_echo_request */
    10,   /* 127: of_error_msg */
    16,   /* 128: of_experimenter */
    16,   /* 129: of_experimenter_error_msg */
    24,   /* 130: of_experimenter_stats_reply */
    24,   /* 131: of_experimenter_stats_request */
    32,   /* 132: of_features_reply */
    8,    /* 133: of_features_request */
    56,   /* 134: of_flow_add */
    56,   /* 135: of_flow_delete */
    56,   /* 136: of_flow_delete_strict */
    56,   /* 137: of_flow_mod */
    12,   /* 138: of_flow_mod_failed_error_msg */
    56,   /* 139: of_flow_modify */
    56,   /* 140: of_flow_modify_strict */
    -1,   /* 141: of_flow_monitor_failed_error_msg */
    56,   /* 142: of_flow_removed */
    16,   /* 143: of_flow_stats_reply */
    56,   /* 144: of_flow_stats_request */
    12,   /* 145: of_get_config_reply */
    8,    /* 146: of_get_config_request */
    16,   /* 147: of_group_add */
    16,   /* 148: of_group_delete */
    16,   /* 149: of_group_desc_stats_reply */
    16,   /* 150: of_group_desc_stats_request */
    56,   /* 151: of_group_features_stats_reply */
    16,   /* 152: of_group_features_stats_request */
    16,   /* 153: of_group_mod */
    12,   /* 154: of_group_mod_failed_error_msg */
    16,   /* 155: of_group_modify */
    16,   /* 156: of_group_stats_reply */
    24,   /* 157: of_group_stats_request */
    8,    /* 158: of_header */
    8,    /* 159: of_hello */
    12,   /* 160: of_hello_failed_error_msg */
    -1,   /* 161: of_meter_config_stats_reply */
    -1,   /* 162: of_meter_config_stats_request */
    -1,   /* 163: of_meter_features_stats_reply */
    -1,   /* 164: of_meter_features_stats_request */
    -1,   /* 165: of_meter_mod */
    -1,   /* 166: of_meter_mod_failed_error_msg */
    -1,   /* 167: of_meter_stats_reply */
    -1,   /* 168: of_meter_stats_request */
    -1,   /* 169: of_nicira_controller_role_reply */
    -1,   /* 170: of_nicira_controller_role_request */
    16,   /* 171: of_nicira_header */
    26,   /* 172: of_packet_in */
    24,   /* 173: of_packet_out */
    -1,   /* 174: of_port_desc_stats_reply */
    -1,   /* 175: of_port_desc_stats_request */
    40,   /* 176: of_port_mod */
    12,   /* 177: of_port_mod_failed_error_msg */
    16,   /* 178: of_port_stats_reply */
    24,   /* 179: of_port_stats_request */
    80,   /* 180: of_port_status */
    -1,   /* 181: of_queue_desc_stats_reply */
    -1,   /* 182: of_queue_desc_stats_request */
    16,   /* 183: of_queue_get_config_reply */
    16,   /* 184: of_queue_get_config_request */
    12,   /* 185: of_queue_op_failed_error_msg */
    16,   /* 186: of_queue_stats_reply */
    24,   /* 187: of_queue_stats_request */
    -1,   /* 188: of_requestforward */
    24,   /* 189: of_role_reply */
    24,   /* 190: of_role_request */
    12,   /* 191: of_role_request_failed_error_msg */
    -1,   /* 192: of_role_status */
    12,   /* 193: of_set_config */
    16,   /* 194: of_stats_reply */
    16,   /* 195: of_stats_request */
    12,   /* 196: of_switch_config_failed_error_msg */
    -1,   /* 197: of_table_desc_stats_reply */
    -1,   /* 198: of_table_desc_stats_request */
    -1,   /* 199: of_table_features_failed_error_msg */
    -1,   /* 200: of_table_features_stats_reply */
    -1,   /* 201: of_table_features_stats_request */
    16,   /* 202: of_table_mod */
    12,   /* 203: of_table_mod_failed_error_msg */
    16,   /* 204: of_table_stats_reply */
    16,   /* 205: of_table_stats_request */
    -1,   /* 206: of_table_status */
    8,    /* 207: of_action */
    16,   /* 208: of_action_bsn */
    28,   /* 209: of_action_bsn_checksum */
    -1,   /* 210: of_action_bsn_gentable */
    24,   /* 211: of_action_bsn_mirror */
    16,   /* 212: of_action_bsn_set_tunnel_dst */
    8,    /* 213: of_action_copy_ttl_in */
    8,    /* 214: of_action_copy_ttl_out */
    8,    /* 215: of_action_dec_mpls_ttl */
    8,    /* 216: of_action_dec_nw_ttl */
    -1,   /* 217: of_action_enqueue */
    8,    /* 218: of_action_experimenter */
    8,    /* 219: of_action_group */
    -1,   /* 220: of_action_id */
    -1,   /* 221: of_action_id_bsn */
    -1,   /* 222: of_action_id_bsn_checksum */
    -1,   /* 223: of_action_id_bsn_gentable */
    -1,   /* 224: of_action_id_bsn_mirror */
    -1,   /* 225: of_action_id_bsn_set_tunnel_dst */
    -1,   /* 226: of_action_id_copy_ttl_in */
    -1,   /* 227: of_action_id_copy_ttl_out */
    -1,   /* 228: of_action_id_dec_mpls_ttl */
    -1,   /* 229: of_action_id_dec_nw_ttl */
    -1,   /* 230: of_action_id_experimenter */
    -1,   /* 231: of_action_id_group */
    -1,   /* 232: of_action_id_nicira */
    -1,   /* 233: of_action_id_nicira_dec_ttl */
    -1,   /* 234: of_action_id_output */
    -1,   /* 235: of_action_id_pop_mpls */
    -1,   /* 236: of_action_id_pop_pbb */
    -1,   /* 237: of_action_id_pop_vlan */
    -1,   /* 238: of_action_id_push_mpls */
    -1,   /* 239: of_action_id_push_pbb */
    -1,   /* 240: of_action_id_push_vlan */
    -1,   /* 241: of_action_id_set_field */
    -1,   /* 242: of_action_id_set_mpls_ttl */
    -1,   /* 243: of_action_id_set_nw_ttl */
    -1,   /* 244: of_action_id_set_queue */
    16,   /* 245: of_action_nicira */
    16,   /* 246: of_action_nicira_dec_ttl */
    16,   /* 247: of_action_output */
    8,    /* 248: of_action_pop_mpls */
    -1,   /* 249: of_action_pop_pbb */
    8,    /* 250: of_action_pop_vlan */
    8,    /* 251: of_action_push_mpls */
    -1,   /* 252: of_action_push_pbb */
    8,    /* 253: of_action_push_vlan */
    -1,   /* 254: of_action_set_dl_dst */
    -1,   /* 255: of_action_set_dl_src */
    8,    /* 256: of_action_set_field */
    -1,   /* 257: of_action_set_mpls_label */
    -1,   /* 258: of_action_set_mpls_tc */
    8,    /* 259: of_action_set_mpls_ttl */
    -1,   /* 260: of_action_set_nw_dst */
    -1,   /* 261: of_action_set_nw_ecn */
    -1,   /* 262: of_action_set_nw_src */
    -1,   /* 263: of_action_set_nw_tos */
    8,    /* 264: of_action_set_nw_ttl */
    8,    /* 265: of_action_set_queue */
    -1,   /* 266: of_action_set_tp_dst */
    -1,   /* 267: of_action_set_tp_src */
    -1,   /* 268: of_action_set_vlan_pcp */
    -1,   /* 269: of_action_set_vlan_vid */
    -1,   /* 270: of_action_strip_vlan */
    -1,   /* 271: of_async_config_prop */
    -1,   /* 272: of_async_config_prop_experimenter_master */
    -1,   /* 273: of_async_config_prop_experimenter_slave */
    -1,   /* 274: of_async_config_prop_flow_removed_master */
    -1,   /* 275: of_async_config_prop_flow_removed_slave */
    -1,   /* 276: of_async_config_prop_packet_in_master */
    -1,   /* 277: of_async_config_prop_packet_in_slave */
    -1,   /* 278: of_async_config_prop_port_status_master */
    -1,   /* 279: of_async_config_prop_port_status_slave */
    -1,   /* 280: of_async_config_prop_requestforward_master */
    -1,   /* 281: of_async_config_prop_requestforward_slave */
    -1,   /* 282: of_async_config_prop_role_status_master */
    -1,   /* 283: of_async_config_prop_role_status_slave */
    -1,   /* 284: of_async_config_prop_table_status_master */
    -1,   /* 285: of_async_config_prop_table_status_slave */
    -1,   /* 286: of_bsn_controller_connection */
    -1,   /* 287: of_bsn_debug_counter_desc_stats_entry */
    -1,   /* 288: of_bsn_debug_counter_stats_entry */
    -1,   /* 289: of_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 290: of_bsn_generic_stats_entry */
    -1,   /* 291: of_bsn_gentable_bucket_stats_entry */
    -1,   /* 292: of_bsn_gentable_desc_stats_entry */
    -1,   /* 293: of_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 294: of_bsn_gentable_entry_stats_entry */
    -1,   /* 295: of_bsn_gentable_stats_entry */
    32,   /* 296: of_bsn_interface */
    -1,   /* 297: of_bsn_lacp_stats_entry */
    -1,   /* 298: of_bsn_port_counter_stats_entry */
    -1,   /* 299: of_bsn_switch_pipeline_stats_entry */
    -1,   /* 300: of_bsn_table_checksum_stats_entry */
    -1,   /* 301: of_bsn_tlv */
    -1,   /* 302: of_bsn_tlv_actor_key */
    -1,   /* 303: of_bsn_tlv_actor_port_num */
    -1,   /* 304: of_bsn_tlv_actor_port_priority */
    -1,   /* 305: of_bsn_tlv_actor_state */
    -1,   /* 306: of_bsn_tlv_actor_system_mac */
    -1,   /* 307: of_bsn_tlv_actor_system_priority */
    -1,   /* 308: of_bsn_tlv_anchor */
    -1,   /* 309: of_bsn_tlv_broadcast_query_timeout */
    -1,   /* 310: of_bsn_tlv_broadcast_rate */
    -1,   /* 311: of_bsn_tlv_bucket */
    -1,   /* 312: of_bsn_tlv_circuit_id */
    -1,   /* 313: of_bsn_tlv_convergence_status */
    -1,   /* 314: of_bsn_tlv_crc_enabled */
    -1,   /* 315: of_bsn_tlv_data */
    -1,   /* 316: of_bsn_tlv_decap */
    -1,   /* 317: of_bsn_tlv_eth_dst */
    -1,   /* 318: of_bsn_tlv_eth_src */
    -1,   /* 319: of_bsn_tlv_external_gateway_ip */
    -1,   /* 320: of_bsn_tlv_external_gateway_mac */
    -1,   /* 321: of_bsn_tlv_external_ip */
    -1,   /* 322: of_bsn_tlv_external_mac */
    -1,   /* 323: of_bsn_tlv_external_netmask */
    -1,   /* 324: of_bsn_tlv_generation_id */
    -1,   /* 325: of_bsn_tlv_header_size */
    -1,   /* 326: of_bsn_tlv_icmp_code */
    -1,   /* 327: of_bsn_tlv_icmp_id */
    -1,   /* 328: of_bsn_tlv_icmp_type */
    -1,   /* 329: of_bsn_tlv_idle_notification */
    -1,   /* 330: of_bsn_tlv_idle_time */
    -1,   /* 331: of_bsn_tlv_idle_timeout */
    -1,   /* 332: of_bsn_tlv_igmp_snooping */
    -1,   /* 333: of_bsn_tlv_internal_gateway_mac */
    -1,   /* 334: of_bsn_tlv_internal_mac */
    -1,   /* 335: of_bsn_tlv_interval */
    -1,   /* 336: of_bsn_tlv_ip_proto */
    -1,   /* 337: of_bsn_tlv_ipv4 */
    -1,   /* 338: of_bsn_tlv_ipv4_dst */
    -1,   /* 339: of_bsn_tlv_ipv4_netmask */
    -1,   /* 340: of_bsn_tlv_ipv4_src */
    -1,   /* 341: of_bsn_tlv_ipv6 */
    -1,   /* 342: of_bsn_tlv_known_multicast_rate */
    -1,   /* 343: of_bsn_tlv_l2_multicast_lookup */
    -1,   /* 344: of_bsn_tlv_mac */
    -1,   /* 345: of_bsn_tlv_mac_mask */
    -1,   /* 346: of_bsn_tlv_mcg_type_vxlan */
    -1,   /* 347: of_bsn_tlv_miss_packets */
    -1,   /* 348: of_bsn_tlv_mpls_control_word */
    -1,   /* 349: of_bsn_tlv_mpls_label */
    -1,   /* 350: of_bsn_tlv_mpls_sequenced */
    -1,   /* 351: of_bsn_tlv_multicast_interface_id */
    -1,   /* 352: of_bsn_tlv_name */
    -1,   /* 353: of_bsn_tlv_negate */
    -1,   /* 354: of_bsn_tlv_nexthop_type_vxlan */
    -1,   /* 355: of_bsn_tlv_offset */
    -1,   /* 356: of_bsn_tlv_partner_key */
    -1,   /* 357: of_bsn_tlv_partner_port_num */
    -1,   /* 358: of_bsn_tlv_partner_port_priority */
    -1,   /* 359: of_bsn_tlv_partner_state */
    -1,   /* 360: of_bsn_tlv_partner_system_mac */
    -1,   /* 361: of_bsn_tlv_partner_system_priority */
    -1,   /* 362: of_bsn_tlv_port */
    -1,   /* 363: of_bsn_tlv_port_vxlan_mode */
    -1,   /* 364: of_bsn_tlv_priority */
    -1,   /* 365: of_bsn_tlv_queue_id */
    -1,   /* 366: of_bsn_tlv_queue_weight */
    -1,   /* 367: of_bsn_tlv_rate_unit */
    -1,   /* 368: of_bsn_tlv_reference */
    -1,   /* 369: of_bsn_tlv_reply_packets */
    -1,   /* 370: of_bsn_tlv_request_packets */
    -1,   /* 371: of_bsn_tlv_rx_bytes */
    -1,   /* 372: of_bsn_tlv_rx_packets */
    -1,   /* 373: of_bsn_tlv_sampling_rate */
    -1,   /* 374: of_bsn_tlv_set_loopback_mode */
    -1,   /* 375: of_bsn_tlv_status */
    -1,   /* 376: of_bsn_tlv_strip_mpls_l2_on_ingress */
    -1,   /* 377: of_bsn_tlv_strip_mpls_l3_on_ingress */
    -1,   /* 378: of_bsn_tlv_strip_vlan_on_egress */
    -1,   /* 379: of_bsn_tlv_sub_agent_id */
    -1,   /* 380: of_bsn_tlv_tcp_dst */
    -1,   /* 381: of_bsn_tlv_tcp_src */
    -1,   /* 382: of_bsn_tlv_tx_bytes */
    -1,   /* 383: of_bsn_tlv_tx_packets */
    -1,   /* 384: of_bsn_tlv_udf_anchor */
    -1,   /* 385: of_bsn_tlv_udf_id */
    -1,   /* 386: of_bsn_tlv_udf_length */
    -1,   /* 387: of_bsn_tlv_udf_offset */
    -1,   /* 388: of_bsn_tlv_udp_dst */
    -1,   /* 389: of_bsn_tlv_udp_src */
    -1,   /* 390: of_bsn_tlv_unicast_query_timeout */
    -1,   /* 391: of_bsn_tlv_unicast_rate */
    -1,   /* 392: of_bsn_tlv_unknown_multicast_rate */
    -1,   /* 393: of_bsn_tlv_use_packet_state */
    -1,   /* 394: of_bsn_tlv_vfi */
    -1,   /* 395: of_bsn_tlv_vlan_mac_list */
    -1,   /* 396: of_bsn_tlv_vlan_pcp */
    -1,   /* 397: of_bsn_tlv_vlan_vid */
    -1,   /* 398: of_bsn_tlv_vlan_vid_mask */
    -1,   /* 399: of_bsn_tlv_vni */
    -1,   /* 400: of_bsn_tlv_vrf */
    -1,   /* 401: of_bsn_vlan_counter_stats_entry */
    -1,   /* 402: of_bsn_vlan_mac */
    4,    /* 403: of_bsn_vport */
    64,   /* 404: of_bsn_vport_l2gre */
    32,   /* 405: of_bsn_vport_q_in_q */
    -1,   /* 406: of_bsn_vrf_counter_stats_entry */
    16,   /* 407: of_bucket */
    16,   /* 408: of_bucket_counter */
    -1,   /* 409: of_bundle_prop */
    -1,   /* 410: of_bundle_prop_experimenter */
    56,   /* 411: of_flow_stats_entry */
    8,    /* 412: of_group_desc_stats_entry */
    32,   /* 413: of_group_stats_entry */
    -1,   /* 414: of_hello_elem */
    -1,   /* 415: of_hello_elem_versionbitmap */
    8,    /* 416: of_instruction */
    8,    /* 417: of_instruction_apply_actions */
    -1,   /* 418: of_instruction_bsn */
    -1,   /* 419: of_instruction_bsn_arp_offload */
    -1,   /* 420: of_instruction_bsn_auto_negotiation */
    -1,   /* 421: of_instruction_bsn_deny */
    -1,   /* 422: of_instruction_bsn_dhcp_offload */
    -1,   /* 423: of_instruction_bsn_disable_l3 */
    -1,   /* 424: of_instruction_bsn_disable_split_horizon_check */
    -1,   /* 425: of_instruction_bsn_disable_src_mac_check */
    -1,   /* 426: of_instruction_bsn_disable_vlan_counters */
    -1,   /* 427: of_instruction_bsn_internal_priority */
    -1,   /* 428: of_instruction_bsn_packet_of_death */
    -1,   /* 429: of_instruction_bsn_permit */
    -1,   /* 430: of_instruction_bsn_prioritize_pdus */
    -1,   /* 431: of_instruction_bsn_require_vlan_xlate */
    -1,   /* 432: of_instruction_bsn_span_destination */
    8,    /* 433: of_instruction_clear_actions */
    8,    /* 434: of_instruction_experimenter */
    8,    /* 435: of_instruction_goto_table */
    -1,   /* 436: of_instruction_id */
    -1,   /* 437: of_instruction_id_apply_actions */
    -1,   /* 438: of_instruction_id_bsn */
    -1,   /* 439: of_instruction_id_bsn_arp_offload */
    -1,   /* 440: of_instruction_id_bsn_auto_negotiation */
    -1,   /* 441: of_instruction_id_bsn_deny */
    -1,   /* 442: of_instruction_id_bsn_dhcp_offload */
    -1,   /* 443: of_instruction_id_bsn_disable_l3 */
    -1,   /* 444: of_instruction_id_bsn_disable_split_horizon_check */
    -1,   /* 445: of_instruction_id_bsn_disable_src_mac_check */
    -1,   /* 446: of_instruction_id_bsn_disable_vlan_counters */
    -1,   /* 447: of_instruction_id_bsn_internal_priority */
    -1,   /* 448: of_instruction_id_bsn_packet_of_death */
    -1,   /* 449: of_instruction_id_bsn_permit */
    -1,   /* 450: of_instruction_id_bsn_prioritize_pdus */
    -1,   /* 451: of_instruction_id_bsn_require_vlan_xlate */
    -1,   /* 452: of_instruction_id_bsn_span_destination */
    -1,   /* 453: of_instruction_id_clear_actions */
    -1,   /* 454: of_instruction_id_experimenter */
    -1,   /* 455: of_instruction_id_goto_table */
    -1,   /* 456: of_instruction_id_meter */
    -1,   /* 457: of_instruction_id_write_actions */
    -1,   /* 458: of_instruction_id_write_metadata */
    -1,   /* 459: of_instruction_meter */
    8,    /* 460: of_instruction_write_actions */
    24,   /* 461: of_instruction_write_metadata */
    -1,   /* 462: of_match_v1 */
    -1,   /* 463: of_match_v2 */
    4,    /* 464: of_match_v3 */
    -1,   /* 465: of_meter_band */
    -1,   /* 466: of_meter_band_drop */
    -1,   /* 467: of_meter_band_dscp_remark */
    -1,   /* 468: of_meter_band_experimenter */
    -1,   /* 469: of_meter_band_stats */
    -1,   /* 470: of_meter_config */
    -1,   /* 471: of_meter_features */
    -1,   /* 472: of_meter_stats */
    4,    /* 473: of_oxm */
    6,    /* 474: of_oxm_arp_op */
    8,    /* 475: of_oxm_arp_op_masked */
    10,   /* 476: of_oxm_arp_sha */
    16,   /* 477: of_oxm_arp_sha_masked */
    8,    /* 478: of_oxm_arp_spa */
    12,   /* 479: of_oxm_arp_spa_masked */
    10,   /* 480: of_oxm_arp_tha */
    16,   /* 481: of_oxm_arp_tha_masked */
    8,    /* 482: of_oxm_arp_tpa */
    12,   /* 483: of_oxm_arp_tpa_masked */
    8,    /* 484: of_oxm_bsn_egr_port_group_id */
    12,   /* 485: of_oxm_bsn_egr_port_group_id_masked */
    5,    /* 486: of_oxm_bsn_global_vrf_allowed */
    6,    /* 487: of_oxm_bsn_global_vrf_allowed_masked */
    20,   /* 488: of_oxm_bsn_in_ports_128 */
    36,   /* 489: of_oxm_bsn_in_ports_128_masked */
    68,   /* 490: of_oxm_bsn_in_ports_512 */
    132,  /* 491: of_oxm_bsn_in_ports_512_masked */
    8,    /* 492: of_oxm_bsn_ingress_port_group_id */
    12,   /* 493: of_oxm_bsn_ingress_port_group_id_masked */
    -1,   /* 494: of_oxm_bsn_inner_eth_dst */
    -1,   /* 495: of_oxm_bsn_inner_eth_dst_masked */
    -1,   /* 496: of_oxm_bsn_inner_eth_src */
    -1,   /* 497: of_oxm_bsn_inner_eth_src_masked */
    -1,   /* 498: of_oxm_bsn_inner_vlan_vid */
    -1,   /* 499: of_oxm_bsn_inner_vlan_vid_masked */
    5,    /* 500: of_oxm_bsn_l2_cache_hit */
    6,    /* 501: of_oxm_bsn_l2_cache_hit_masked */
    8,    /* 502: of_oxm_bsn_l3_dst_class_id */
    12,   /* 503: of_oxm_bsn_l3_dst_class_id_masked */
    8,    /* 504: of_oxm_bsn_l3_interface_class_id */
    12,   /* 505: of_oxm_bsn_l3_interface_class_id_masked */
    8,    /* 506: of_oxm_bsn_l3_src_class_id */
    12,   /* 507: of_oxm_bsn_l3_src_class_id_masked */
    8,    /* 508: of_oxm_bsn_lag_id */
    12,   /* 509: of_oxm_bsn_lag_id_masked */
    6,    /* 510: of_oxm_bsn_tcp_flags */
    8,    /* 511: of_oxm_bsn_tcp_flags_masked */
    8,    /* 512: of_oxm_bsn_udf0 */
    12,   /* 513: of_oxm_bsn_udf0_masked */
    8,    /* 514: of_oxm_bsn_udf1 */
    12,   /* 515: of_oxm_bsn_udf1_masked */
    8,    /* 516: of_oxm_bsn_udf2 */
    12,   /* 517: of_oxm_bsn_udf2_masked */
    8,    /* 518: of_oxm_bsn_udf3 */
    12,   /* 519: of_oxm_bsn_udf3_masked */
    8,    /* 520: of_oxm_bsn_udf4 */
    12,   /* 521: of_oxm_bsn_udf4_masked */
    8,    /* 522: of_oxm_bsn_udf5 */
    12,   /* 523: of_oxm_bsn_udf5_masked */
    8,    /* 524: of_oxm_bsn_udf6 */
    12,   /* 525: of_oxm_bsn_udf6_masked */
    8,    /* 526: of_oxm_bsn_udf7 */
    12,   /* 527: of_oxm_bsn_udf7_masked */
    8,    /* 528: of_oxm_bsn_vlan_xlate_port_group_id */
    12,   /* 529: of_oxm_bsn_vlan_xlate_port_group_id_masked */
    8,    /* 530: of_oxm_bsn_vrf */
    12,   /* 531: of_oxm_bsn_vrf_masked */
    -1,   /* 532: of_oxm_bsn_vxlan_network_id */
    -1,   /* 533: of_oxm_bsn_vxlan_network_id_masked */
    10,   /* 534: of_oxm_eth_dst */
    16,   /* 535: of_oxm_eth_dst_masked */
    10,   /* 536: of_oxm_eth_src */
    16,   /* 537: of_oxm_eth_src_masked */
    6,    /* 538: of_oxm_eth_type */
    8,    /* 539: of_oxm_eth_type_masked */
    5,    /* 540: of_oxm_icmpv4_code */
    6,    /* 541: of_oxm_icmpv4_code_masked */
    5,    /* 542: of_oxm_icmpv4_type */
    6,    /* 543: of_oxm_icmpv4_type_masked */
    5,    /* 544: of_oxm_icmpv6_code */
    6,    /* 545: of_oxm_icmpv6_code_masked */
    5,    /* 546: of_oxm_icmpv6_type */
    6,    /* 547: of_oxm_icmpv6_type_masked */
    8,    /* 548: of_oxm_in_phy_port */
    12,   /* 549: of_oxm_in_phy_port_masked */
    8,    /* 550: of_oxm_in_port */
    12,   /* 551: of_oxm_in_port_masked */
    5,    /* 552: of_oxm_ip_dscp */
    6,    /* 553: of_oxm_ip_dscp_masked */
    5,    /* 554: of_oxm_ip_ecn */
    6,    /* 555: of_oxm_ip_ecn_masked */
    5,    /* 556: of_oxm_ip_proto */
    6,    /* 557: of_oxm_ip_proto_masked */
    8,    /* 558: of_oxm_ipv4_dst */
    12,   /* 559: of_oxm_ipv4_dst_masked */
    8,    /* 560: of_oxm_ipv4_src */
    12,   /* 561: of_oxm_ipv4_src_masked */
    20,   /* 562: of_oxm_ipv6_dst */
    36,   /* 563: of_oxm_ipv6_dst_masked */
    -1,   /* 564: of_oxm_ipv6_exthdr */
    -1,   /* 565: of_oxm_ipv6_exthdr_masked */
    8,    /* 566: of_oxm_ipv6_flabel */
    12,   /* 567: of_oxm_ipv6_flabel_masked */
    10,   /* 568: of_oxm_ipv6_nd_sll */
    16,   /* 569: of_oxm_ipv6_nd_sll_masked */
    20,   /* 570: of_oxm_ipv6_nd_target */
    36,   /* 571: of_oxm_ipv6_nd_target_masked */
    10,   /* 572: of_oxm_ipv6_nd_tll */
    16,   /* 573: of_oxm_ipv6_nd_tll_masked */
    20,   /* 574: of_oxm_ipv6_src */
    36,   /* 575: of_oxm_ipv6_src_masked */
    12,   /* 576: of_oxm_metadata */
    20,   /* 577: of_oxm_metadata_masked */
    -1,   /* 578: of_oxm_mpls_bos */
    -1,   /* 579: of_oxm_mpls_bos_masked */
    8,    /* 580: of_oxm_mpls_label */
    12,   /* 581: of_oxm_mpls_label_masked */
    5,    /* 582: of_oxm_mpls_tc */
    6,    /* 583: of_oxm_mpls_tc_masked */
    -1,   /* 584: of_oxm_pbb_uca */
    -1,   /* 585: of_oxm_pbb_uca_masked */
    6,    /* 586: of_oxm_sctp_dst */
    8,    /* 587: of_oxm_sctp_dst_masked */
    6,    /* 588: of_oxm_sctp_src */
    8,    /* 589: of_oxm_sctp_src_masked */
    6,    /* 590: of_oxm_tcp_dst */
    8,    /* 591: of_oxm_tcp_dst_masked */
    6,    /* 592: of_oxm_tcp_src */
    8,    /* 593: of_oxm_tcp_src_masked */
    -1,   /* 594: of_oxm_tunnel_id */
    -1,   /* 595: of_oxm_tunnel_id_masked */
    8,    /* 596: of_oxm_tunnel_ipv4_dst */
    12,   /* 597: of_oxm_tunnel_ipv4_dst_masked */
    8,    /* 598: of_oxm_tunnel_ipv4_src */
    12,   /* 599: of_oxm_tunnel_ipv4_src_masked */
    6,    /* 600: of_oxm_udp_dst */
    8,    /* 601: of_oxm_udp_dst_masked */
    6,    /* 602: of_oxm_udp_src */
    8,    /* 603: of_oxm_udp_src_masked */
    5,    /* 604: of_oxm_vlan_pcp */
    6,    /* 605: of_oxm_vlan_pcp_masked */
    6,    /* 606: of_oxm_vlan_vid */
    8,    /* 607: of_oxm_vlan_vid_masked */
    16,   /* 608: of_packet_queue */
    64,   /* 609: of_port_desc */
    -1,   /* 610: of_port_desc_prop */
    -1,   /* 611: of_port_desc_prop_bsn */
    -1,   /* 612: of_port_desc_prop_bsn_generation_id */
    -1,   /* 613: of_port_desc_prop_bsn_uplink */
    -1,   /* 614: of_port_desc_prop_ethernet */
    -1,   /* 615: of_port_desc_prop_experimenter */
    -1,   /* 616: of_port_desc_prop_optical */
    -1,   /* 617: of_port_mod_prop */
    -1,   /* 618: of_port_mod_prop_ethernet */
    -1,   /* 619: of_port_mod_prop_experimenter */
    -1,   /* 620: of_port_mod_prop_optical */
    104,  /* 621: of_port_stats_entry */
    -1,   /* 622: of_port_stats_prop */
    -1,   /* 623: of_port_stats_prop_ethernet */
    -1,   /* 624: of_port_stats_prop_experimenter */
    -1,   /* 625: of_port_stats_prop_optical */
    -1,   /* 626: of_queue_desc */
    -1,   /* 627: of_queue_desc_prop */
    -1,   /* 628: of_queue_desc_prop_experimenter */
    -1,   /* 629: of_queue_desc_prop_max_rate */
    -1,   /* 630: of_queue_desc_prop_min_rate */
    8,    /* 631: of_queue_prop */
    16,   /* 632: of_queue_prop_experimenter */
    16,   /* 633: of_queue_prop_max_rate */
    16,   /* 634: of_queue_prop_min_rate */
    32,   /* 635: of_queue_stats_entry */
    -1,   /* 636: of_queue_stats_prop */
    -1,   /* 637: of_queue_stats_prop_experimenter */
    -1,   /* 638: of_role_prop */
    -1,   /* 639: of_role_prop_experimenter */
    -1,   /* 640: of_table_desc */
    -1,   /* 641: of_table_feature_prop */
    -1,   /* 642: of_table_feature_prop_apply_actions */
    -1,   /* 643: of_table_feature_prop_apply_actions_miss */
    -1,   /* 644: of_table_feature_prop_apply_setfield */
    -1,   /* 645: of_table_feature_prop_apply_setfield_miss */
    -1,   /* 646: of_table_feature_prop_experimenter */
    -1,   /* 647: of_table_feature_prop_experimenter_miss */
    -1,   /* 648: of_table_feature_prop_instructions */
    -1,   /* 649: of_table_feature_prop_instructions_miss */
    -1,   /* 650: of_table_feature_prop_match */
    -1,   /* 651: of_table_feature_prop_next_tables */
    -1,   /* 652: of_table_feature_prop_next_tables_miss */
    -1,   /* 653: of_table_feature_prop_table_sync_from */
    -1,   /* 654: of_table_feature_prop_wildcards */
    -1,   /* 655: of_table_feature_prop_write_actions */
    -1,   /* 656: of_table_feature_prop_write_actions_miss */
    -1,   /* 657: of_table_feature_prop_write_setfield */
    -1,   /* 658: of_table_feature_prop_write_setfield_miss */
    -1,   /* 659: of_table_features */
    -1,   /* 660: of_table_mod_prop */
    -1,   /* 661: of_table_mod_prop_eviction */
    -1,   /* 662: of_table_mod_prop_experimenter */
    -1,   /* 663: of_table_mod_prop_vacancy */
    128,  /* 664: of_table_stats_entry */
    -1,   /* 665: of_uint32 */
    -1,   /* 666: of_uint64 */
    -1,   /* 667: of_uint8 */
    0,    /* 668: of_list_action */
    -1,   /* 669: of_list_action_id */
    -1,   /* 670: of_list_async_config_prop */
    -1,   /* 671: of_list_bsn_controller_connection */
    -1,   /* 672: of_list_bsn_debug_counter_desc_stats_entry */
    -1,   /* 673: of_list_bsn_debug_counter_stats_entry */
    -1,   /* 674: of_list_bsn_flow_checksum_bucket_stats_entry */
    -1,   /* 675: of_list_bsn_generic_stats_entry */
    -1,   /* 676: of_list_bsn_gentable_bucket_stats_entry */
    -1,   /* 677: of_list_bsn_gentable_desc_stats_entry */
    -1,   /* 678: of_list_bsn_gentable_entry_desc_stats_entry */
    -1,   /* 679: of_list_bsn_gentable_entry_stats_entry */
    -1,   /* 680: of_list_bsn_gentable_stats_entry */
    0,    /* 681: of_list_bsn_interface */
    -1,   /* 682: of_list_bsn_lacp_stats_entry */
    -1,   /* 683: of_list_bsn_port_counter_stats_entry */
    -1,   /* 684: of_list_bsn_switch_pipeline_stats_entry */
    -1,   /* 685: of_list_bsn_table_checksum_stats_entry */
    -1,   /* 686: of_list_bsn_tlv */
    -1,   /* 687: of_list_bsn_vlan_counter_stats_entry */
    -1,   /* 688: of_list_bsn_vlan_mac */
    -1,   /* 689: of_list_bsn_vrf_counter_stats_entry */
    0,    /* 690: of_list_bucket */
    0,    /* 691: of_list_bucket_counter */
    -1,   /* 692: of_list_bundle_prop */
    0,    /* 693: of_list_flow_stats_entry */
    0,    /* 694: of_list_group_desc_stats_entry */
    0,    /* 695: of_list_group_stats_entry */
    -1,   /* 696: of_list_hello_elem */
    0,    /* 697: of_list_instruction */
    -1,   /* 698: of_list_instruction_id */
    -1,   /* 699: of_list_meter_band */
    -1,   /* 700: of_list_meter_band_stats */
    -1,   /* 701: of_list_meter_config */
    -1,   /* 702: of_list_meter_stats */
    0,    /* 703: of_list_oxm */
    0,    /* 704: of_list_packet_queue */
    0,    /* 705: of_list_port_desc */
    -1,   /* 706: of_list_port_desc_prop */
    -1,   /* 707: of_list_port_mod_prop */
    0,    /* 708: of_list_port_stats_entry */
    -1,   /* 709: of_list_port_stats_prop */
    -1,   /* 710: of_list_queue_desc */
    -1,   /* 711: of_list_queue_desc_prop */
    0,    /* 712: of_list_queue_prop */
    0,    /* 713: of_list_queue_stats_entry */
    -1,   /* 714: of_list_queue_stats_prop */
    -1,   /* 715: of_list_role_prop */
    -1,   /* 716: of_list_table_desc */
    -1,   /* 717: of_list_table_feature_prop */
    -1,   /* 718: of_list_table_features */
    -1,   /* 719: of_list_table_mod_prop */
    0,    /* 720: of_list_table_stats_entry */
    -1,   /* 721: of_list_uint32 */
    -1,   /* 722: of_list_uint64 */
    -1    /* 723: of_list_uint8 */
};

static const int
of_object_fixed_len_v4[OF_OBJECT_COUNT] = {
    -1,   /* of_object is not instantiable */
    40,   /* 1: of_aggregate_stats_reply */
    56,   /* 2: of_aggregate_stats_request */
    -1,   /* 3: of_async_config_failed_error_msg */
    32,   /* 4: of_async_get_reply */
    8,    /* 5: of_async_get_request */
    32,   /* 6: of_async_set */
    12,   /* 7: of_bad_action_error_msg */
    12,   /* 8: of_bad_instruction_error_msg */
    12,   /* 9: of_bad_match_error_msg */
    -1,   /* 10: of_bad_property_error_msg */
    12,   /* 11: of_bad_request_error_msg */
    8,    /* 12: of_barrier_reply */
    8,    /* 13: of_barrier_request */
    24,   /* 14: of_bsn_arp_idle */
    272,  /* 15: of_bsn_base_error */
    20,   /* 16: of_bsn_bw_clear_data_reply */
    16,   /* 17: of_bsn_bw_clear_data_request */
    20,   /* 18: of_bsn_bw_enable_get_reply */
    16,   /* 19: of_bsn_bw_enable_get_request */
    24,   /* 20: of_bsn_bw_enable_set_reply */
    20,   /* 21: of_bsn_bw_enable_set_request */
    16,   /* 22: of_bsn_controller_connections_reply */
    16,   /* 23: of_bsn_controller_connections_request */
    24,   /* 24: of_bsn_debug_counter_desc_stats_reply */
    24,   /* 25: of_bsn_debug_counter_desc_stats_request */
    24,   /* 26: of_bsn_debug_counter_stats_reply */
    24,   /* 27: of_bsn_debug_counter_stats_request */
    272,  /* 28: of_bsn_error */
    24,   /* 29: of_bsn_flow_checksum_bucket_stats_reply */
    25,   /* 30: of_bsn_flow_checksum_bucket_stats_request */
    40,   /* 31: of_bsn_flow_idle */
    20,   /* 32: of_bsn_flow_idle_enable_get_reply */
    16,   /* 33: of_bsn_flow_idle_enable_get_request */
    24,   /* 34: of_bsn_flow_idle_enable_set_reply */
    20,   /* 35: of_bsn_flow_idle_enable_set_request */
    -1,   /* 36: of_bsn_generic_async */
    -1,   /* 37: of_bsn_generic_command */
    24,   /* 38: of_bsn_generic_stats_reply */
    88,   /* 39: of_bsn_generic_stats_request */
    24,   /* 40: of_bsn_gentable_bucket_stats_reply */
    26,   /* 41: of_bsn_gentable_bucket_stats_request */
    28,   /* 42: of_bsn_gentable_clear_reply */
    52,   /* 43: of_bsn_gentable_clear_request */
    24,   /* 44: of_bsn_gentable_desc_stats_reply */
    24,   /* 45: of_bsn_gentable_desc_stats_request */
    36,   /* 46: of_bsn_gentable_entry_add */
    18,   /* 47: of_bsn_gentable_entry_delete */
    24,   /* 48: of_bsn_gentable_entry_desc_stats_reply */
    60,   /* 49: of_bsn_gentable_entry_desc_stats_request */
    24,   /* 50: of_bsn_gentable_entry_stats_reply */
    60,   /* 51: of_bsn_gentable_entry_stats_request */
    24,   /* 52: of_bsn_gentable_set_buckets_size */
    24,   /* 53: of_bsn_gentable_stats_reply */
    24,   /* 54: of_bsn_gentable_stats_request */
    16,   /* 55: of_bsn_get_interfaces_reply */
    16,   /* 56: of_bsn_get_interfaces_request */
    -1,   /* 57: of_bsn_get_ip_mask_reply */
    -1,   /* 58: of_bsn_get_ip_mask_request */
    -1,   /* 59: of_bsn_get_l2_table_reply */
    -1,   /* 60: of_bsn_get_l2_table_request */
    20,   /* 61: of_bsn_get_mirroring_reply */
    20,   /* 62: of_bsn_get_mirroring_request */
    272,  /* 63: of_bsn_get_switch_pipeline_reply */
    16,   /* 64: of_bsn_get_switch_pipeline_request */
    16,   /* 65: of_bsn_header */
    -1,   /* 66: of_bsn_hybrid_get_reply */
    -1,   /* 67: of_bsn_hybrid_get_request */
    536,  /* 68: of_bsn_image_desc_stats_reply */
    24,   /* 69: of_bsn_image_desc_stats_request */
    52,   /* 70: of_bsn_lacp_convergence_notif */
    24,   /* 71: of_bsn_lacp_stats_reply */
    24,   /* 72: of_bsn_lacp_stats_request */
    17,   /* 73: of_bsn_log */
    16,   /* 74: of_bsn_lua_command_reply */
    16,   /* 75: of_bsn_lua_command_request */
    16,   /* 76: of_bsn_lua_notification */
    82,   /* 77: of_bsn_lua_upload */
    25,   /* 78: of_bsn_pdu_rx_reply */
    28,   /* 79: of_bsn_pdu_rx_request */
    21,   /* 80: of_bsn_pdu_rx_timeout */
    25,   /* 81: of_bsn_pdu_tx_reply */
    28,   /* 82: of_bsn_pdu_tx_request */
    24,   /* 83: of_bsn_port_counter_stats_reply */
    28,   /* 84: of_bsn_port_counter_stats_request */
    32,   /* 85: of_bsn_role_status */
    24,   /* 86: of_bsn_set_aux_cxns_reply */
    20,   /* 87: of_bsn_set_aux_cxns_request */
    -1,   /* 88: of_bsn_set_ip_mask */
    -1,   /* 89: of_bsn_set_l2_table_reply */
    -1,   /* 90: of_bsn_set_l2_table_request */
    24,   /* 91: of_bsn_set_lacp_reply */
    38,   /* 92: of_bsn_set_lacp_request */
    20,   /* 93: of_bsn_set_mirroring */
    20,   /* 94: of_bsn_set_pktin_suppression_reply */
    32,   /* 95: of_bsn_set_pktin_suppression_request */
    20,   /* 96: of_bsn_set_switch_pipeline_reply */
    272,  /* 97: of_bsn_set_switch_pipeline_request */
    -1,   /* 98: of_bsn_shell_command */
    -1,   /* 99: of_bsn_shell_output */
    -1,   /* 100: of_bsn_shell_status */
    24,   /* 101: of_bsn_stats_reply */
    24,   /* 102: of_bsn_stats_request */
    24,   /* 103: of_bsn_switch_pipeline_stats_reply */
    24,   /* 104: of_bsn_switch_pipeline_stats_request */
    24,   /* 105: of_bsn_table_checksum_stats_reply */
    24,   /* 106: of_bsn_table_checksum_stats_request */
    24,   /* 107: of_bsn_table_set_buckets_size */
    -1,   /* 108: of_bsn_takeover */
    24,   /* 109: of_bsn_time_reply */
    16,   /* 110: of_bsn_time_request */
    24,   /* 111: of_bsn_virtual_port_create_reply */
    20,   /* 112: of_bsn_virtual_port_create_request */
    20,   /* 113: of_bsn_virtual_port_remove_reply */
    20,   /* 114: of_bsn_virtual_port_remove_request */
    18,   /* 115: of_bsn_vlan_counter_clear */
    24,   /* 116: of_bsn_vlan_counter_stats_reply */
    26,   /* 117: of_bsn_vlan_counter_stats_request */
    24,   /* 118: of_bsn_vrf_counter_stats_reply */
    28,   /* 119: of_bsn_vrf_counter_stats_request */
    -1,   /* 120: of_bundle_add_msg */
    -1,   /* 121: of_bundle_ctrl_msg */
    -1,   /* 122: of_bundle_failed_error_msg */
    1072, /* 123: of_desc_stats_reply */
    16,   /* 124: of_desc_stats_request */
    8,    /* 125: of_echo_reply */
    8,    /* 126: of_echo_request */
    10,   /* 127: of_error_msg */
    16,   /* 128: of_experimenter */
    16,   /* 129: of_experimenter_error_msg */
    24,   /* 130: of_experimenter_stats_reply */
    24,   /* 131: of_experimenter_stats_request */
    32,   /* 132: of_features_reply */
    8,    /* 133: of_features_request */
    56,   /* 134: of_flow_add */
    56,   /* 135: of_flow_delete */
    56,   /* 136: of_flow_delete_strict */
    56,   /* 137: of_flow_mod */
    12,   /* 138: of_flow_mod_failed_error_msg */
    56,   /* 139: of_flow_modify */
    56,   /* 140: of_flow_modify_strict */
    -1,   /* 141: of_flow_monitor_failed_error_msg */
    56,   /* 142: of_flow_removed */
    16,   /* 143: of_flow_stats_reply */
    56,   /* 144: of_flow_stats_request */
    12,   /* 145: of_get_config_reply */
    8,    /* 146: of_get_config_request */
    16,   /* 147: of_group_add */
    16,   /* 148: of_group_delete */
    16,   /* 149: of_group_desc_stats_reply */
    16,   /* 150: of_group_desc_stats_request */
    56,   /* 151: of_group_features_stats_reply */
    16,   /* 152: of_group_features_stats_request */
    16,   /* 153: of_group_mod */
    12,   /* 154: of_group_mod_failed_error_msg */
    16,   /* 155: of_group_modify */
    16,   /* 156: of_group_stats_reply */
    24,   /* 157: of_group_stats_request */
    8,    /* 158: of_header */
    8,    /* 159: of_hello */
    12,   /* 160: of_hello_failed_error_msg */
    16,   /* 161: of_meter_config_stats_reply */
    24,   /* 162: of_meter_config_stats_request */
    32,   /* 163: of_meter_features_stats_reply */
    16,   /* 164: of_meter_features_stats_request */
    16,   /* 165: of_meter_mod */
    12,   /* 166: of_meter_mod_failed_error_msg */
    16,   /* 167: of_meter_stats_reply */
    24,   /* 168: of_meter_stats_request */
    -1,   /* 169: of_nicira_controller_role_reply */
    -1,   /* 170: of_nicira_controller_role_request */
    16,   /* 171: of_nicira_header */
    34,   /* 172: of_packet_in */
    24,   /* 173: of_packet_out */
    16,   /* 174: of_port_desc_stats_reply */
    16,   /* 175: of_port_desc_stats_request */
    40,   /* 176: of_port_mod */
    12,   /* 177: of_port_mod_failed_error_msg */
    16,   /* 178: of_port_stats_reply */
    24,   /* 179: of_port_stats_request */
    80,   /* 180: of_port_status */
    -1,   /* 181: of_queue_desc_stats_reply */
    -1,   /* 182: of_queue_desc_stats_request */
    16,   /* 183: of_queue_get_config_reply */
    16,   /* 184: of_queue_get_config_request */
    12,   /* 185: of_queue_op_failed_error_msg */
    16,   /* 186: of_queue_stats_reply */
    24,   /* 187: of_queue_stats_request */
    -1,   /* 188: of_requestforward */
    24,   /* 189: of_role_reply */
    24,   /* 190: of_role_request */
    12,   /* 191: of_role_request_failed_error_msg */
    -1,   /* 192: of_role_status */
    12,   /* 193: of_set_config */
    16,   /* 194: of_stats_reply */
    16,   /* 195: of_stats_request */
    12,   /* 196: of_switch_config_failed_error_msg */
    -1,   /* 197: of_table_desc_stats_reply */
    -1,   /* 198: of_table_desc_stats_request */
    12,   /* 199: of_table_features_failed_error_msg */
    16,   /* 200: of_table_features_stats_reply */
    16,   /* 201: of_table_features_stats_request */
    16,   /* 202: of_table_mod */
    12,   /* 203: of_table_mod_failed_error_msg */
    16,   /* 204: of_table_stats_reply */
    16,   /* 205: of_table_stats_request */
    -1,   /* 206: of_table_status */
    8,    /* 207: of_action */
    16,   /* 208: of_action_bsn */
    28,   /* 209: of_action_bsn_checksum */
    16,   /* 210: of_action_bsn_gentable */
    24,   /* 211: of_action_bsn_mirror */
    16,   /* 212: of_action_bsn_set_tunnel_dst */
    8,    /* 213: of_action_copy_ttl_in */
    8,    /* 214: of_action_copy_ttl_out */
    8,    /* 215: of_action_dec_mpls_ttl */
    8,    /* 216: of_action_dec_nw_ttl */
    -1,   /* 217: of_action_enqueue */
    8,    /* 218: of_action_experimenter */
    8,    /* 219: of_action_group */
    4,    /* 220: of_action_id */
    12,   /* 221: of_action_id_bsn */
    12,   /* 222: of_action_id_bsn_checksum */
    12,   /* 223: of_action_id_bsn_gentable */
    12,   /* 224: of_action_id_bsn_mirror */
    12,   /* 225: of_action_id_bsn_set_tunnel_dst */
    4,    /* 226: of_action_id_copy_ttl_in */
    4,    /* 227: of_action_id_copy_ttl_out */
    4,    /* 228: of_action_id_dec_mpls_ttl */
    4,    /* 229: of_action_id_dec_nw_ttl */
    8,    /* 230: of_action_id_experimenter */
    4,    /* 231: of_action_id_group */
    10,   /* 232: of_action_id_nicira */
    10,   /* 233: of_action_id_nicira_dec_ttl */
    4,    /* 234: of_action_id_output */
    4,    /* 235: of_action_id_pop_mpls */
    4,    /* 236: of_action_id_pop_pbb */
    4,    /* 237: of_action_id_pop_vlan */
    4,    /* 238: of_action_id_push_mpls */
    4,    /* 239: of_action_id_push_pbb */
    4,    /* 240: of_action_id_push_vlan */
    4,    /* 241: of_action_id_set_field */
    4,    /* 242: of_action_id_set_mpls_ttl */
    4,    /* 243: of_action_id_set_nw_ttl */
    4,    /* 244: of_action_id_set_queue */
    16,   /* 245: of_action_nicira */
    16,   /* 246: of_action_nicira_dec_ttl */
    16,   /* 247: of_action_output */
    8,    /* 248: of_action_pop_mpls */
    8,    /* 249: of_action_pop_pbb */
    8,    /* 250: of_action_pop_vlan */
    8,    /* 251: of_action_push_mpls */
    8,    /* 252: of_action_push_pbb */
    8,    /* 253: of_action_push_vlan */
    -1,   /* 254: of_action_set_dl_dst */
    -1,   /* 255: of_action_set_dl_src */
    8,    /* 256: of_action_set_field */
    -1,   /* 257: of_action_set_mpls_label */
    -1,   /* 258: of_action_set_mpls_tc */
    8,    /* 259: of_action_set_mpls_ttl */
    -1,   /* 260: of_action_set_nw_dst */
    -1,   /* 261: of_action_set_nw_ecn */
    -1,   /* 262: of_action_set_nw_src */
    -1,   /* 263: of_action_set_nw_tos */
    8,    /* 264: of_action_set_nw_ttl */
    8,    /* 265: of_action_set_queue */
    -1,   /* 266: of_action_set_tp_dst */
    -1,   /* 267: of_action_set_tp_src */
    -1,   /* 268: of_action_set_vlan_pcp */
    -1,   /* 269: of_action_set_vlan_vid */
    -1,   /* 270: of_action_strip_vlan */
    -1,   /* 271: of_async_config_prop */
    -1,   /* 272: of_async_config_prop_experimenter_master */
    -1,   /* 273: of_async_config_prop_experimenter_slave */
    -1,   /* 274: of_async_config_prop_flow_removed_master */
    -1,   /* 275: of_async_config_prop_flow_removed_slave */
    -1,   /* 276: of_async_config_prop_packet_in_master */
    -1,   /* 277: of_async_config_prop_packet_in_slave */
    -1,   /* 278: of_async_config_prop_port_status_master */
    -1,   /* 279: of_async_config_prop_port_status_slave */
    -1,   /* 280: of_async_config_prop_requestforward_master */
    -1,   /* 281: of_async_config_prop_requestforward_slave */
    -1,   /* 282: of_async_config_prop_role_status_master */
    -1,   /* 283: of_async_config_prop_role_status_slave */
    -1,   /* 284: of_async_config_prop_table_status_master */
    -1,   /* 285: of_async_config_prop_table_status_slave */
    264,  /* 286: of_bsn_controller_connection */
    328,  /* 287: of_bsn_debug_counter_desc_stats_entry */
    16,   /* 288: of_bsn_debug_counter_stats_entry */
    8,    /* 289: of_bsn_flow_checksum_bucket_stats_entry */
    2,    /* 290: of_bsn_generic_stats_entry */
    16,   /* 291: of_bsn_gentable_bucket_stats_entry */
    48,   /* 292: of_bsn_gentable_desc_stats_entry */
    20,   /* 293: of_bsn_gentable_entry_desc_stats_entry */
    4,    /* 294: of_bsn_gentable_entry_stats_entry */
    24,   /* 295: of_bsn_gentable_stats_entry */
    32,   /* 296: of_bsn_interface */
    36,   /* 297: of_bsn_lacp_stats_entry */
    8,    /* 298: of_bsn_port_counter_stats_entry */
    256,  /* 299: of_bsn_switch_pipeline_stats_entry */
    9,    /* 300: of_bsn_table_checksum_stats_entry */
    4,    /* 301: of_bsn_tlv */
    6,    /* 302: of_bsn_tlv_actor_key */
    6,    /* 303: of_bsn_tlv_actor_port_num */
    6,    /* 304: of_bsn_tlv_actor_port_priority */
    5,    /* 305: of_bsn_tlv_actor_state */
    10,   /* 306: of_bsn_tlv_actor_system_mac */
    6,    /* 307: of_bsn_tlv_actor_system_priority */
    6,    /* 308: of_bsn_tlv_anchor */
    8,    /* 309: of_bsn_tlv_broadcast_query_timeout */
    8,    /* 310: of_bsn_tlv_broadcast_rate */
    4,    /* 311: of_bsn_tlv_bucket */
    4,    /* 312: of_bsn_tlv_circuit_id */
    5,    /* 313: of_bsn_tlv_convergence_status */
    5,    /* 314: of_bsn_tlv_crc_enabled */
    4,    /* 315: of_bsn_tlv_data */
    6,    /* 316: of_bsn_tlv_decap */
    10,   /* 317: of_bsn_tlv_eth_dst */
    10,   /* 318: of_bsn_tlv_eth_src */
    8,    /* 319: of_bsn_tlv_external_gateway_ip */
    10,   /* 320: of_bsn_tlv_external_gateway_mac */
    8,    /* 321: of_bsn_tlv_external_ip */
    10,   /* 322: of_bsn_tlv_external_mac */
    8,    /* 323: of_bsn_tlv_external_netmask */
    12,   /* 324: of_bsn_tlv_generation_id */
    8,    /* 325: of_bsn_tlv_header_size */
    5,    /* 326: of_bsn_tlv_icmp_code */
    6,    /* 327: of_bsn_tlv_icmp_id */
    5,    /* 328: of_bsn_tlv_icmp_type */
    4,    /* 329: of_bsn_tlv_idle_notification */
    12,   /* 330: of_bsn_tlv_idle_time */
    8,    /* 331: of_bsn_tlv_idle_timeout */
    4,    /* 332: of_bsn_tlv_igmp_snooping */
    10,   /* 333: of_bsn_tlv_internal_gateway_mac */
    10,   /* 334: of_bsn_tlv_internal_mac */
    8,    /* 335: of_bsn_tlv_interval */
    5,    /* 336: of_bsn_tlv_ip_proto */
    8,    /* 337: of_bsn_tlv_ipv4 */
    8,    /* 338: of_bsn_tlv_ipv4_dst */
    8,    /* 339: of_bsn_tlv_ipv4_netmask */
    8,    /* 340: of_bsn_tlv_ipv4_src */
    20,   /* 341: of_bsn_tlv_ipv6 */
    8,    /* 342: of_bsn_tlv_known_multicast_rate */
    4,    /* 343: of_bsn_tlv_l2_multicast_lookup */
    10,   /* 344: of_bsn_tlv_mac */
    10,   /* 345: of_bsn_tlv_mac_mask */
    4,    /* 346: of_bsn_tlv_mcg_type_vxlan */
    12,   /* 347: of_bsn_tlv_miss_packets */
    5,    /* 348: of_bsn_tlv_mpls_control_word */
    8,    /* 349: of_bsn_tlv_mpls_label */
    5,    /* 350: of_bsn_tlv_mpls_sequenced */
    8,    /* 351: of_bsn_tlv_multicast_interface_id */
    4,    /* 352: of_bsn_tlv_name */
    4,    /* 353: of_bsn_tlv_negate */
    4,    /* 354: of_bsn_tlv_nexthop_type_vxlan */
    6,    /* 355: of_bsn_tlv_offset */
    6,    /* 356: of_bsn_tlv_partner_key */
    6,    /* 357: of_bsn_tlv_partner_port_num */
    6,    /* 358: of_bsn_tlv_partner_port_priority */
    5,    /* 359: of_bsn_tlv_partner_state */
    10,   /* 360: of_bsn_tlv_partner_system_mac */
    6,    /* 361: of_bsn_tlv_partner_system_priority */
    8,    /* 362: of_bsn_tlv_port */
    5,    /* 363: of_bsn_tlv_port_vxlan_mode */
    8,    /* 364: of_bsn_tlv_priority */
    8,    /* 365: of_bsn_tlv_queue_id */
    8,    /* 366: of_bsn_tlv_queue_weight */
    5,    /* 367: of_bsn_tlv_rate_unit */
    6,    /* 368: of_bsn_tlv_reference */
    12,   /* 369: of_bsn_tlv_reply_packets */
    12,   /* 370: of_bsn_tlv_request_packets */
    12,   /* 371: of_bsn_tlv_rx_bytes */
    12,   /* 372: of_bsn_tlv_rx_packets */
    8,    /* 373: of_bsn_tlv_sampling_rate */
    4,    /* 374: of_bsn_tlv_set_loopback_mode */
    5,    /* 375: of_bsn_tlv_status */
    4,    /* 376: of_bsn_tlv_strip_mpls_l2_on_ingress */
    4,    /* 377: of_bsn_tlv_strip_mpls_l3_on_ingress */
    4,    /* 378: of_bsn_tlv_strip_vlan_on_egress */
    8,    /* 379: of_bsn_tlv_sub_agent_id */
    6,    /* 380: of_bsn_tlv_tcp_dst */
    6,    /* 381: of_bsn_tlv_tcp_src */
    12,   /* 382: of_bsn_tlv_tx_bytes */
    12,   /* 383: of_bsn_tlv_tx_packets */
    6,    /* 384: of_bsn_tlv_udf_anchor */
    6,    /* 385: of_bsn_tlv_udf_id */
    6,    /* 386: of_bsn_tlv_udf_length */
    6,    /* 387: of_bsn_tlv_udf_offset */
    6,    /* 388: of_bsn_tlv_udp_dst */
    6,    /* 389: of_bsn_tlv_udp_src */
    8,    /* 390: of_bsn_tlv_unicast_query_timeout */
    8,    /* 391: of_bsn_tlv_unicast_rate */
    8,    /* 392: of_bsn_tlv_unknown_multicast_rate */
    5,    /* 393: of_bsn_tlv_use_packet_state */
    6,    /* 394: of_bsn_tlv_vfi */
    4,    /* 395: of_bsn_tlv_vlan_mac_list */
    5,    /* 396: of_bsn_tlv_vlan_pcp */
    6,    /* 397: of_bsn_tlv_vlan_vid */
    6,    /* 398: of_bsn_tlv_vlan_vid_mask */
    8,    /* 399: of_bsn_tlv_vni */
    8,    /* 400: of_bsn_tlv_vrf */
    8,    /* 401: of_bsn_vlan_counter_stats_entry */
    8,    /* 402: of_bsn_vlan_mac */
    4,    /* 403: of_bsn_vport */
    64,   /* 404: of_bsn_vport_l2gre */
    32,   /* 405: of_bsn_vport_q_in_q */
    8,    /* 406: of_bsn_vrf_counter_stats_entry */
    16,   /* 407: of_bucket */
    16,   /* 408: of_bucket_counter */
    -1,   /* 409: of_bundle_prop */
    -1,   /* 410: of_bundle_prop_experimenter */
    56,   /* 411: of_flow_stats_entry */
    8,    /* 412: of_group_desc_stats_entry */
    40,   /* 413: of_group_stats_entry */
    4,    /* 414: of_hello_elem */
    4,    /* 415: of_hello_elem_versionbitmap */
    4,    /* 416: of_instruction */
    8,    /* 417: of_instruction_apply_actions */
    16,   /* 418: of_instruction_bsn */
    16,   /* 419: of_instruction_bsn_arp_offload */
    16,   /* 420: of_instruction_bsn_auto_negotiation */
    16,   /* 421: of_instruction_bsn_deny */
    16,   /* 422: of_instruction_bsn_dhcp_offload */
    16,   /* 423: of_instruction_bsn_disable_l3 */
    16,   /* 424: of_instruction_bsn_disable_split_horizon_check */
    16,   /* 425: of_instruction_bsn_disable_src_mac_check */
    16,   /* 426: of_instruction_bsn_disable_vlan_counters */
    16,   /* 427: of_instruction_bsn_internal_priority */
    16,   /* 428: of_instruction_bsn_packet_of_death */
    16,   /* 429: of_instruction_bsn_permit */
    16,   /* 430: of_instruction_bsn_prioritize_pdus */
    16,   /* 431: of_instruction_bsn_require_vlan_xlate */
    16,   /* 432: of_instruction_bsn_span_destination */
    8,    /* 433: of_instruction_clear_actions */
    8,    /* 434: of_instruction_experimenter */
    8,    /* 435: of_instruction_goto_table */
    4,    /* 436: of_instruction_id */
    4,    /* 437: of_instruction_id_apply_actions */
    12,   /* 438: of_instruction_id_bsn */
    12,   /* 439: of_instruction_id_bsn_arp_offload */
    12,   /* 440: of_instruction_id_bsn_auto_negotiation */
    12,   /* 441: of_instruction_id_bsn_deny */
    12,   /* 442: of_instruction_id_bsn_dhcp_offload */
    12,   /* 443: of_instruction_id_bsn_disable_l3 */
    12,   /* 444: of_instruction_id_bsn_disable_split_horizon_check */
    12,   /* 445: of_instruction_id_bsn_disable_src_mac_check */
    12,   /* 446: of_instruction_id_bsn_disable_vlan_counters */
    12,   /* 447: of_instruction_id_bsn_internal_priority */
    12,   /* 448: of_instruction_id_bsn_packet_of_death */
    12,   /* 449: of_instruction_id_bsn_permit */
    12,   /* 450: of_instruction_id_bsn_prioritize_pdus */
    12,   /* 451: of_instruction_id_bsn_require_vlan_xlate */
    12,   /* 452: of_instruction_id_bsn_span_destination */
    4,    /* 453: of_instruction_id_clear_actions */
    8,    /* 454: of_instruction_id_experimenter */
    4,    /* 455: of_instruction_id_goto_table */
    4,    /* 456: of_instruction_id_meter */
    4,    /* 457: of_instruction_id_write_actions */
    4,    /* 458: of_instruction_id_write_metadata */
    8,    /* 459: of_instruction_meter */
    8,    /* 460: of_instruction_write_actions */
    24,   /* 461: of_instruction_write_metadata */
    -1,   /* 462: of_match_v1 */
    -1,   /* 463: of_match_v2 */
    4,    /* 464: of_match_v3 */
    4,    /* 465: of_meter_band */
    16,   /* 466: of_meter_band_drop */
    16,   /* 467: of_meter_band_dscp_remark */
    16,   /* 468: of_meter_band_experimenter */
    16,   /* 469: of_meter_band_stats */
    8,    /* 470: of_meter_config */
    16,   /* 471: of_meter_features */
    40,   /* 472: of_meter_stats */
    4,    /* 473: of_oxm */
    6,    /* 474: of_oxm_arp_op */
    8,    /* 475: of_oxm_arp_op_masked */
    10,   /* 476: of_oxm_arp_sha */
    16,   /* 477: of_oxm_arp_sha_masked */
    8,    /* 478: of_oxm_arp_spa */
    12,   /* 479: of_oxm_arp_spa_masked */
    10,   /* 480: of_oxm_arp_tha */
    16,   /* 481: of_oxm_arp_tha_masked */
    8,    /* 482: of_oxm_arp_tpa */
    12,   /* 483: of_oxm_arp_tpa_masked */
    8,    /* 484: of_oxm_bsn_egr_port_group_id */
    12,   /* 485: of_oxm_bsn_egr_port_group_id_masked */
    5,    /* 486: of_oxm_bsn_global_vrf_allowed */
    6,    /* 487: of_oxm_bsn_global_vrf_allowed_masked */
    20,   /* 488: of_oxm_bsn_in_ports_128 */
    36,   /* 489: of_oxm_bsn_in_ports_128_masked */
    68,   /* 490: of_oxm_bsn_in_ports_512 */
    132,  /* 491: of_oxm_bsn_in_ports_512_masked */
    8,    /* 492: of_oxm_bsn_ingress_port_group_id */
    12,   /* 493: of_oxm_bsn_ingress_port_group_id_masked */
    10,   /* 494: of_oxm_bsn_inner_eth_dst */
    16,   /* 495: of_oxm_bsn_inner_eth_dst_masked */
    10,   /* 496: of_oxm_bsn_inner_eth_src */
    16,   /* 497: of_oxm_bsn_inner_eth_src_masked */
    6,    /* 498: of_oxm_bsn_inner_vlan_vid */
    8,    /* 499: of_oxm_bsn_inner_vlan_vid_masked */
    5,    /* 500: of_oxm_bsn_l2_cache_hit */
    6,    /* 501: of_oxm_bsn_l2_cache_hit_masked */
    8,    /* 502: of_oxm_bsn_l3_dst_class_id */
    12,   /* 503: of_oxm_bsn_l3_dst_class_id_masked */
    8,    /* 504: of_oxm_bsn_l3_interface_class_id */
    12,   /* 505: of_oxm_bsn_l3_interface_class_id_masked */
    8,    /* 506: of_oxm_bsn_l3_src_class_id */
    12,   /* 507: of_oxm_bsn_l3_src_class_id_masked */
    8,    /* 508: of_oxm_bsn_lag_id */
    12,   /* 509: of_oxm_bsn_lag_id_masked */
    6,    /* 510: of_oxm_bsn_tcp_flags */
    8,    /* 511: of_oxm_bsn_tcp_flags_masked */
    8,    /* 512: of_oxm_bsn_udf0 */
    12,   /* 513: of_oxm_bsn_udf0_masked */
    8,    /* 514: of_oxm_bsn_udf1 */
    12,   /* 515: of_oxm_bsn_udf1_masked */
    8,    /* 516: of_oxm_bsn_udf2 */
    12,   /* 517: of_oxm_bsn_udf2_masked */
    8,    /* 518: of_oxm_bsn_udf3 */
    12,   /* 519: of_oxm_bsn_udf3_masked */
    8,    /* 520: of_oxm_bsn_udf4 */
    12,   /* 521: of_oxm_bsn_udf4_masked */
    8,    /* 522: of_oxm_bsn_udf5 */
    12,   /* 523: of_oxm_bsn_udf5_masked */
    8,    /* 524: of_oxm_bsn_udf6 */
    12,   /* 525: of_oxm_bsn_udf6_masked */
    8,    /* 526: of_oxm_bsn_udf7 */
    12,   /* 527: of_oxm_bsn_udf7_masked */
    8,    /* 528: of_oxm_bsn_vlan_xlate_port_group_id */
    12,   /* 529: of_oxm_bsn_vlan_xlate_port_group_id_masked */
    8,    /* 530: of_oxm_bsn_vrf */
    12,   /* 531: of_oxm_bsn_vrf_masked */
    8,    /* 532: of_oxm_bsn_vxlan_network_id */
    12,   /* 533: of_oxm_bsn_vxlan_network_id_masked */
    10,   /* 534: of_oxm_eth_dst */
    16,   /* 535: of_oxm_eth_dst_masked */
    10,   /* 536: of_oxm_eth_src */
    16,   /* 537: of_oxm_eth_src_masked */
    6,    /* 538: of_oxm_eth_type */
    8,    /* 539: of_oxm_eth_type_masked */
    5,    /* 540: of_oxm_icmpv4_code */
    6,    /* 541: of_oxm_icmpv4_code_masked */
    5,    /* 542: of_oxm_icmpv4_type */
    6,    /* 543: of_oxm_icmpv4_type_masked */
    5,    /* 544: of_oxm_icmpv6_code */
    6,    /* 545: of_oxm_icmpv6_code_masked */
    5,    /* 546: of_oxm_icmpv6_type */
    6,    /* 547: of_oxm_icmpv6_type_masked */
    8,    /* 548: of_oxm_in_phy_port */
    12,   /* 549: of_oxm_in_phy_port_masked */
    8,    /* 550: of_oxm_in_port */
    12,   /* 551: of_oxm_in_port_masked */
    5,    /* 552: of_oxm_ip_dscp */
    6,    /* 553: of_oxm_ip_dscp_masked */
    5,    /* 554: of_oxm_ip_ecn */
    6,    /* 555: of_oxm_ip_ecn_masked */
    5,    /* 556: of_oxm_ip_proto */
    6,    /* 557: of_oxm_ip_proto_masked */
    8,    /* 558: of_oxm_ipv4_dst */
    12,   /* 559: of_oxm_ipv4_dst_masked */
    8,    /* 560: of_oxm_ipv4_src */
    12,   /* 561: of_oxm_ipv4_src_masked */
    20,   /* 562: of_oxm_ipv6_dst */
    36,   /* 563: of_oxm_ipv6_dst_masked */
    6,    /* 564: of_oxm_ipv6_exthdr */
    8,    /* 565: of_oxm_ipv6_exthdr_masked */
    8,    /* 566: of_oxm_ipv6_flabel */
    12,   /* 567: of_oxm_ipv6_flabel_masked */
    10,   /* 568: of_oxm_ipv6_nd_sll */
    16,   /* 569: of_oxm_ipv6_nd_sll_masked */
    20,   /* 570: of_oxm_ipv6_nd_target */
    36,   /* 571: of_oxm_ipv6_nd_target_masked */
    10,   /* 572: of_oxm_ipv6_nd_tll */
    16,   /* 573: of_oxm_ipv6_nd_tll_masked */
    20,   /* 574: of_oxm_ipv6_src */
    36,   /* 575: of_oxm_ipv6_src_masked */
    12,   /* 576: of_oxm_metadata */
    20,   /* 577: of_oxm_metadata_masked */
    5,    /* 578: of_oxm_mpls_bos */
    6,    /* 579: of_oxm_mpls_bos_masked */
    8,    /* 580: of_oxm_mpls_label */
    12,   /* 581: of_oxm_mpls_label_masked */
    5,    /* 582: of_oxm_mpls_tc */
    6,    /* 583: of_oxm_mpls_tc_masked */
    -1,   /* 584: of_oxm_pbb_uca */
    -1,   /* 585: of_oxm_pbb_uca_masked */
    6,    /* 586: of_oxm_sctp_dst */
    8,    /* 587: of_oxm_sctp_dst_masked */
    6,    /* 588: of_oxm_sctp_src */
    8,    /* 589: of_oxm_sctp_src_masked */
    6,    /* 590: of_oxm_tcp_dst */
    8,    /* 591: of_oxm_tcp_dst_masked */
    6,    /* 592: of_oxm_tcp_src */
    8,    /* 593: of_oxm_tcp_src_masked */
    12,   /* 594: of_oxm_tunnel_id */
    20,   /* 595: of_oxm_tunnel_id_masked */
    8,    /* 596: of_oxm_tunnel_ipv4_dst */
    12,   /* 597: of_oxm_tunnel_ipv4_dst_masked */
    8,    /* 598: of_oxm_tunnel_ipv4_src */
    12,   /* 599: of_oxm_tunnel_ipv4_src_masked */
    6,    /* 600: of_oxm_udp_dst */
    8,    /* 601: of_oxm_udp_dst_masked */
    6,    /* 602: of_oxm_udp_src */
    8,    /* 603: of_oxm_udp_src_masked */
    5,    /* 604: of_oxm_vlan_pcp */
    6,    /* 605: of_oxm_vlan_pcp_masked */
    6,    /* 606: of_oxm_vlan_vid */
    8,    /* 607: of_oxm_vlan_vid_masked */
    16,   /* 608: of_packet_queue */
    64,   /* 609: of_port_desc */
    -1,   /* 610: of_port_desc_prop */
    -1,   /* 611: of_port_desc_prop_bsn */
    -1,   /* 612: of_port_desc_prop_bsn_generation_id */
    -1,   /* 613: of_port_desc_prop_bsn_uplink */
    -1,   /* 614: of_port_desc_prop_ethernet */
    -1,   /* 615: of_port_desc_prop_experimenter */
    -1,   /* 616: of_port_desc_prop_optical */
    -1,   /* 617: of_port_mod_prop */
    -1,   /* 618: of_port_mod_prop_ethernet */
    -1,   /* 619: of_port_mod_prop_experimenter */
    -1,   /* 620: of_port_mod_prop_optical */
    112,  /* 621: of_port_stats_entry */
    -1,   /* 622: of_port_stats_prop */
    -1,   /* 623: of_port_stats_prop_ethernet */
    -1,   /* 624: of_port_stats_prop_experimenter */
    -1,   /* 625: of_port_stats_prop_optical */
    -1,   /* 626: of_queue_desc */
    -1,   /* 627: of_queue_desc_prop */
    -1,   /* 628: of_queue_desc_prop_experimenter */
    -1,   /* 629: of_queue_desc_prop_max_rate */
    -1,   /* 630: of_queue_desc_prop_min_rate */
    8,    /* 631: of_queue_prop */
    16,   /* 632: of_queue_prop_experimenter */
    16,   /* 633: of_queue_prop_max_rate */
    16,   /* 634: of_queue_prop_min_rate */
    40,   /* 635: of_queue_stats_entry */
    -1,   /* 636: of_queue_stats_prop */
    -1,   /* 637: of_queue_stats_prop_experimenter */
    -1,   /* 638: of_role_prop */
    -1,   /* 639: of_role_prop_experimenter */
    -1,   /* 640: of_table_desc */
    4,    /* 641: of_table_feature_prop */
    4,    /* 642: of_table_feature_prop_apply_actions */
    4,    /* 643: of_table_feature_prop_apply_actions_miss */
    4,    /* 644: of_table_feature_prop_apply_setfield */
    4,    /* 645: of_table_feature_prop_apply_setfield_miss */
    12,   /* 646: of_table_feature_prop_experimenter */
    12,   /* 647: of_table_feature_prop_experimenter_miss */
    4,    /* 648: of_table_feature_prop_instructions */
    4,    /* 649: of_table_feature_prop_instructions_miss */
    4,    /* 650: of_table_feature_prop_match */
    4,    /* 651: of_table_feature_prop_next_tables */
    4,    /* 652: of_table_feature_prop_next_tables_miss */
    -1,   /* 653: of_table_feature_prop_table_sync_from */
    4,    /* 654: of_table_feature_prop_wildcards */
    4,    /* 655: of_table_feature_prop_write_actions */
    4,    /* 656: of_table_feature_prop_write_actions_miss */
    4,    /* 657: of_table_feature_prop_write_setfield */
    4,    /* 658: of_table_feature_prop_write_setfield_miss */
    64,   /* 659: of_table_features */
    -1,   /* 660: of_table_mod_prop */
    -1,   /* 661: of_table_mod_prop_eviction */
    -1,   /* 662: of_table_mod_prop_experimenter */
    -1,   /* 663: of_table_mod_prop_vacancy */
    24,   /* 664: of_table_stats_entry */
    4,    /* 665: of_uint32 */
    8,    /* 666: of_uint64 */
    1,    /* 667: of_uint8 */
    0,    /* 668: of_list_action */
    0,    /* 669: of_list_action_id */
    -1,   /* 670: of_list_async_config_prop */
    0,    /* 671: of_list_bsn_controller_connection */
    0,    /* 672: of_list_bsn_debug_counter_desc_stats_entry */
    0,    /* 673: of_list_bsn_debug_counter_stats_entry */
    0,    /* 674: of_list_bsn_flow_checksum_bucket_stats_entry */
    0,    /* 675: of_list_bsn_generic_stats_entry */
    0,    /* 676: of_list_bsn_gentable_bucket_stats_entry */
    0,    /* 677: of_list_bsn_gentable_desc_stats_entry */
    0,    /* 678: of_list_bsn_gentable_entry_desc_stats_entry */
    0,    /* 679: of_list_bsn_gentable_entry_stats_entry */
    0,    /* 680: of_list_bsn_gentable_stats_entry */
    0,    /* 681: of_list_bsn_interface */
    0,    /* 682: of_list_bsn_lacp_stats_entry */
    0,    /* 683: of_list_bsn_port_counter_stats_entry */
    0,    /* 684: of_list_bsn_switch_pipeline_stats_entry */
    0,    /* 685: of_list_bsn_table_checksum_stats_entry */
    0,    /* 686: of_list_bsn_tlv */
    0,    /* 687: of_list_bsn_vlan_counter_stats_entry */
    0,    /* 688: of_list_bsn_vlan_mac */
    0,    /* 689: of_list_bsn_vrf_counter_stats_entry */
    0,    /* 690: of_list_bucket */
    0,    /* 691: of_list_bucket_counter */
    -1,   /* 692: of_list_bundle_prop */
    0,    /* 693: of_list_flow_stats_entry */
    0,    /* 694: of_list_group_desc_stats_entry */
    0,    /* 695: of_list_group_stats_entry */
    0,    /* 696: of_list_hello_elem */
    0,    /* 697: of_list_instruction */
    0,    /* 698: of_list_instruction_id */
    0,    /* 699: of_list_meter_band */
    0,    /* 700: of_list_meter_band_stats */
    0,    /* 701: of_list_meter_config */
    0,    /* 702: of_list_meter_stats */
    0,    /* 703: of_list_oxm */
    0,    /* 704: of_list_packet_queue */
    0,    /* 705: of_list_port_desc */
    -1,   /* 706: of_list_port_desc_prop */
    -1,   /* 707: of_list_port_mod_prop */
    0,    /* 708: of_list_port_stats_entry */
    -1,   /* 709: of_list_port_stats_prop */
    -1,   /* 710: of_list_queue_desc */
    -1,   /* 711: of_list_queue_desc_prop */
    0,    /* 712: of_list_queue_prop */
    0,    /* 713: of_list_queue_stats_entry */
    -1,   /* 714: of_list_queue_stats_prop */
    -1,   /* 715: of_list_role_prop */
    -1,   /* 716: of_list_table_desc */
    0,    /* 717: of_list_table_feature_prop */
    0,    /* 718: of_list_table_features */
    -1,   /* 719: of_list_table_mod_prop */
    0,    /* 720: of_list_table_stats_entry */
    0,    /* 721: of_list_uint32 */
    0,    /* 722: of_list_uint64 */
    0     /* 723: of_list_uint8 */
};

static const int
of_object_fixed_len_v5[OF_OBJECT_COUNT] = {
    -1,   /* of_object is not instantiable */
    40,   /* 1: of_aggregate_stats_reply */
    56,   /* 2: of_aggregate_stats_request */
    12,   /* 3: of_async_config_failed_error_msg */
    8,    /* 4: of_async_get_reply */
    8,    /* 5: of_async_get_request */
    8,    /* 6: of_async_set */
    12,   /* 7: of_bad_action_error_msg */
    12,   /* 8: of_bad_instruction_error_msg */
    12,   /* 9: of_bad_match_error_msg */
    12,   /* 10: of_bad_property_error_msg */
    12,   /* 11: of_bad_request_error_msg */
    8,    /* 12: of_barrier_reply */
    8,    /* 13: of_barrier_request */
    24,   /* 14: of_bsn_arp_idle */
    272,  /* 15: of_bsn_base_error */
    20,   /* 16: of_bsn_bw_clear_data_reply */
    16,   /* 17: of_bsn_bw_clear_data_request */
    20,   /* 18: of_bsn_bw_enable_get_reply */
    16,   /* 19: of_bsn_bw_enable_get_request */
    24,   /* 20: of_bsn_bw_enable_set_reply */
    20,   /* 21: of_bsn_bw_enable_set_request */
    16,   /* 22: of_bsn_controller_connections_reply */
    16,   /* 23: of_bsn_controller_connections_request */
    24,   /* 24: of_bsn_debug_counter_desc_stats_reply */
    24,   /* 25: of_bsn_debug_counter_desc_stats_request */
    24,   /* 26: of_bsn_debug_counter_stats_reply */
    24,   /* 27: of_bsn_debug_counter_stats_request */
    272,  /* 28: of_bsn_error */
    24,   /* 29: of_bsn_flow_checksum_bucket_stats_reply */
    25,   /* 30: of_bsn_flow_checksum_bucket_stats_request */
    40,   /* 31: of_bsn_flow_idle */
    20,   /* 32: of_bsn_flow_idle_enable_get_reply */
    16,   /* 33: of_bsn_flow_idle_enable_get_request */
    24,   /* 34: of_bsn_flow_idle_enable_set_reply */
    20,   /* 35: of_bsn_flow_idle_enable_set_request */
    80,   /* 36: of_bsn_generic_async */
    80,   /* 37: of_bsn_generic_command */
    24,   /* 38: of_bsn_generic_stats_reply */
    88,   /* 39: of_bsn_generic_stats_request */
    24,   /* 40: of_bsn_gentable_bucket_stats_reply */
    26,   /* 41: of_bsn_gentable_bucket_stats_request */
    28,   /* 42: of_bsn_gentable_clear_reply */
    52,   /* 43: of_bsn_gentable_clear_request */
    24,   /* 44: of_bsn_gentable_desc_stats_reply */
    24,   /* 45: of_bsn_gentable_desc_stats_request */
    36,   /* 46: of_bsn_gentable_entry_add */
    18,   /* 47: of_bsn_gentable_entry_delete */
    24,   /* 48: of_bsn_gentable_entry_desc_stats_reply */
    60,   /* 49: of_bsn_gentable_entry_desc_stats_request */
    24,   /* 50: of_bsn_gentable_entry_stats_reply */
    60,   /* 51: of_bsn_gentable_entry_stats_request */
    24,   /* 52: of_bsn_gentable_set_buckets_size */
    24,   /* 53: of_bsn_gentable_stats_reply */
    24,   /* 54: of_bsn_gentable_stats_request */
    16,   /* 55: of_bsn_get_interfaces_reply */
    16,   /* 56: of_bsn_get_interfaces_request */
    -1,   /* 57: of_bsn_get_ip_mask_reply */
    -1,   /* 58: of_bsn_get_ip_mask_request */
    -1,   /* 59: of_bsn_get_l2_table_reply */
    -1,   /* 60: of_bsn_get_l2_table_request */
    20,   /* 61: of_bsn_get_mirroring_reply */
    20,   /* 62: of_bsn_get_mirroring_request */
    272,  /* 63: of_bsn_get_switch_pipeline_reply */
    16,   /* 64: of_bsn_get_switch_pipeline_request */
    16,   /* 65: of_bsn_header */
    -1,   /* 66: of_bsn_hybrid_get_reply */
    -1,   /* 67: of_bsn_hybrid_get_request */
    536,  /* 68: of_bsn_image_desc_stats_reply */
    24,   /* 69: of_bsn_image_desc_stats_request */
    52,   /* 70: of_bsn_lacp_convergence_notif */
    24,   /* 71: of_bsn_lacp_stats_reply */
    24,   /* 72: of_bsn_lacp_stats_request */
    17,   /* 73: of_bsn_log */
    16,   /* 74: of_bsn_lua_command_reply */
    16,   /* 75: of_bsn_lua_command_request */
    16,   /* 76: of_bsn_lua_notification */
    82,   /* 77: of_bsn_lua_upload */
    25,   /* 78: of_bsn_pdu_rx_reply */
    28,   /* 79: of_bsn_pdu_rx_request */
    21,   /* 80: of_bsn_pdu_rx_timeout */
    25,   /* 81: of_bsn_pdu_tx_reply */
    28,   /* 82: of_bsn_pdu_tx_request */
    24,   /* 83: of_bsn_port_counter_stats_reply */
    28,   /* 84: of_bsn_port_counter_stats_request */
    -1,   /* 85: of_bsn_role_status */
    24,   /* 86: of_bsn_set_aux_cxns_reply */
    20,   /* 87: of_bsn_set_aux_cxns_request */
    -1,   /* 88: of_bsn_set_ip_mask */
    -1,   /* 89: of_bsn_set_l2_table_reply */
    -1,   /* 90: of_bsn_set_l2_table_request */
    24,   /* 91: of_bsn_set_lacp_reply */
    38,   /* 92: of_bsn_set_lacp_request */
    20,   /* 93: of_bsn_set_mirroring */
    20,   /* 94: of_bsn_set_pktin_suppression_reply */
    32,   /* 95: of_bsn_set_pktin_suppression_request */
    20,   /* 96: of_bsn_set_switch_pipeline_reply */
    272,  /* 97: of_bsn_set_switch_pipeline_request */
    -1,   /* 98: of_bsn_shell_command */
    -1,   /* 99: of_bsn_shell_output */
    -1,   /* 100: of_bsn_shell_status */
    24,   /* 101: of_bsn_stats_reply */
    24,   /* 102: of_bsn_stats_request */
    24,   /* 103: of_bsn_switch_pipeline_stats_reply */
    24,   /* 104: of_bsn_switch_pipeline_stats_request */
    24,   /* 105: of_bsn_table_checksum_stats_reply */
    24,   /* 106: of_bsn_table_checksum_stats_request */
    24,   /* 107: of_bsn_table_set_buckets_size */
    16,   /* 108: of_bsn_takeover */
    24,   /* 109: of_bsn_time_reply */
    16,   /* 110: of_bsn_time_request */
    24,   /* 111: of_bsn_virtual_port_create_reply */
    20,   /* 112: of_bsn_virtual_port_create_request */
    20,   /* 113: of_bsn_virtual_port_remove_reply */
    20,   /* 114: of_bsn_virtual_port_remove_request */
    18,   /* 115: of_bsn_vlan_counter_clear */
    24,   /* 116: of_bsn_vlan_counter_stats_reply */
    26,   /* 117: of_bsn_vlan_counter_stats_request */
    24,   /* 118: of_bsn_vrf_counter_stats_reply */
    28,   /* 119: of_bsn_vrf_counter_stats_request */
    16,   /* 120: of_bundle_add_msg */
    16,   /* 121: of_bundle_ctrl_msg */
    12,   /* 122: of_bundle_failed_error_msg */
    1072, /* 123: of_desc_stats_reply */
    16,   /* 124: of_desc_stats_request */
    8,    /* 125: of_echo_reply */
    8,    /* 126: of_echo_request */
    10,   /* 127: of_error_msg */
    16,   /* 128: of_experimenter */
    16,   /* 129: of_experimenter_error_msg */
    24,   /* 130: of_experimenter_stats_reply */
    24,   /* 131: of_experimenter_stats_request */
    32,   /* 132: of_features_reply */
    8,    /* 133: of_features_request */
    56,   /* 134: of_flow_add */
    56,   /* 135: of_flow_delete */
    56,   /* 136: of_flow_delete_strict */
    56,   /* 137: of_flow_mod */
    12,   /* 138: of_flow_mod_failed_error_msg */
    56,   /* 139: of_flow_modify */
    56,   /* 140: of_flow_modify_strict */
    12,   /* 141: of_flow_monitor_failed_error_msg */
    56,   /* 142: of_flow_removed */
    16,   /* 143: of_flow_stats_reply */
    56,   /* 144: of_flow_stats_request */
    12,   /* 145: of_get_config_reply */
    8,    /* 146: of_get_config_request */
    16,   /* 147: of_group_add */
    16,   /* 148: of_group_delete */
    16,   /* 149: of_group_desc_stats_reply */
    16,   /* 150: of_group_desc_stats_request */
    56,   /* 151: of_group_features_stats_reply */
    16,   /* 152: of_group_features_stats_request */
    16,   /* 153: of_group_mod */
    12,   /* 154: of_group_mod_failed_error_msg */
    16,   /* 155: of_group_modify */
    16,   /* 156: of_group_stats_reply */
    24,   /* 157: of_group_stats_request */
    8,    /* 158: of_header */
    8,    /* 159: of_hello */
    12,   /* 160: of_hello_failed_error_msg */
    16,   /* 161: of_meter_config_stats_reply */
    24,   /* 162: of_meter_config_stats_request */
    32,   /* 163: of_meter_features_stats_reply */
    16,   /* 164: of_meter_features_stats_request */
    16,   /* 165: of_meter_mod */
    12,   /* 166: of_meter_mod_failed_error_msg */
    16,   /* 167: of_meter_stats_reply */
    24,   /* 168: of_meter_stats_request */
    -1,   /* 169: of_nicira_controller_role_reply */
    -1,   /* 170: of_nicira_controller_role_request */
    16,   /* 171: of_nicira_header */
    34,   /* 172: of_packet_in */
    24,   /* 173: of_packet_out */
    16,   /* 174: of_port_desc_stats_reply */
    16,   /* 175: of_port_desc_stats_request */
    32,   /* 176: of_port_mod */
    12,   /* 177: of_port_mod_failed_error_msg */
    16,   /* 178: of_port_stats_reply */
    24,   /* 179: of_port_stats_request */
    56,   /* 180: of_port_status */
    16,   /* 181: of_queue_desc_stats_reply */
    16,   /* 182: of_queue_desc_stats_request */
    -1,   /* 183: of_queue_get_config_reply */
    -1,   /* 184: of_queue_get_config_request */
    12,   /* 185: of_queue_op_failed_error_msg */
    16,   /* 186: of_queue_stats_reply */
    24,   /* 187: of_queue_stats_request */
    12,   /* 188: of_requestforward */
    24,   /* 189: of_role_reply */
    24,   /* 190: of_role_request */
    12,   /* 191: of_role_request_failed_error_msg */
    24,   /* 192: of_role_status */
    12,   /* 193: of_set_config */
    16,   /* 194: of_stats_reply */
    16,   /* 195: of_stats_request */
    12,   /* 196: of_switch_config_failed_error_msg */
    16,   /* 197: of_table_desc_stats_reply */
    16,   /* 198: of_table_desc_stats_request */
    12,   /* 199: of_table_features_failed_error_msg */
    16,   /* 200: of_table_features_stats_reply */
    16,   /* 201: of_table_features_stats_request */
    16,   /* 202: of_table_mod */
    12,   /* 203: of_table_mod_failed_error_msg */
    16,   /* 204: of_table_stats_reply */
    16,   /* 205: of_table_stats_request */
    28,   /* 206: of_table_status */
    8,    /* 207: of_action */
    16,   /* 208: of_action_bsn */
    28,   /* 209: of_action_bsn_checksum */
    16,   /* 210: of_action_bsn_gentable */
    24,   /* 211: of_action_bsn_mirror */
    16,   /* 212: of_action_bsn_set_tunnel_dst */
    8,    /* 213: of_action_copy_ttl_in */
    8,    /* 214: of_action_copy_ttl_out */
    8,    /* 215: of_action_dec_mpls_ttl */
    8,    /* 216: of_action_dec_nw_ttl */
    -1,   /* 217: of_action_enqueue */
    8,    /* 218: of_action_experimenter */
    8,    /* 219: of_action_group */
    4,    /* 220: of_action_id */
    12,   /* 221: of_action_id_bsn */
    12,   /* 222: of_action_id_bsn_checksum */
    12,   /* 223: of_action_id_bsn_gentable */
    12,   /* 224: of_action_id_bsn_mirror */
    12,   /* 225: of_action_id_bsn_set_tunnel_dst */
    4,    /* 226: of_action_id_copy_ttl_in */
    4,    /* 227: of_action_id_copy_ttl_out */
    4,    /* 228: of_action_id_dec_mpls_ttl */
    4,    /* 229: of_action_id_dec_nw_ttl */
    8,    /* 230: of_action_id_experimenter */
    4,    /* 231: of_action_id_group */
    10,   /* 232: of_action_id_nicira */
    10,   /* 233: of_action_id_nicira_dec_ttl */
    4,    /* 234: of_action_id_output */
    4,    /* 235: of_action_id_pop_mpls */
    4,    /* 236: of_action_id_pop_pbb */
    4,    /* 237: of_action_id_pop_vlan */
    4,    /* 238: of_action_id_push_mpls */
    4,    /* 239: of_action_id_push_pbb */
    4,    /* 240: of_action_id_push_vlan */
    4,    /* 241: of_action_id_set_field */
    4,    /* 242: of_action_id_set_mpls_ttl */
    4,    /* 243: of_action_id_set_nw_ttl */
    4,    /* 244: of_action_id_set_queue */
    16,   /* 245: of_action_nicira */
    16,   /* 246: of_action_nicira_dec_ttl */
    16,   /* 247: of_action_output */
    8,    /* 248: of_action_pop_mpls */
    8,    /* 249: of_action_pop_pbb */
    8,    /* 250: of_action_pop_vlan */
    8,    /* 251: of_action_push_mpls */
    8,    /* 252: of_action_push_pbb */
    8,    /* 253: of_action_push_vlan */
    -1,   /* 254: of_action_set_dl_dst */
    -1,   /* 255: of_action_set_dl_src */
    8,    /* 256: of_action_set_field */
    -1,   /* 257: of_action_set_mpls_label */
    -1,   /* 258: of_action_set_mpls_tc */
    8,    /* 259: of_action_set_mpls_ttl */
    -1,   /* 260: of_action_set_nw_dst */
    -1,   /* 261: of_action_set_nw_ecn */
    -1,   /* 262: of_action_set_nw_src */
    -1,   /* 263: of_action_set_nw_tos */
    8,    /* 264: of_action_set_nw_ttl */
    8,    /* 265: of_action_set_queue */
    -1,   /* 266: of_action_set_tp_dst */
    -1,   /* 267: of_action_set_tp_src */
    -1,   /* 268: of_action_set_vlan_pcp */
    -1,   /* 269: of_action_set_vlan_vid */
    -1,   /* 270: of_action_strip_vlan */
    4,    /* 271: of_async_config_prop */
    4,    /* 272: of_async_config_prop_experimenter_master */
    4,    /* 273: of_async_config_prop_experimenter_slave */
    8,    /* 274: of_async_config_prop_flow_removed_master */
    8,    /* 275: of_async_config_prop_flow_removed_slave */
    8,    /* 276: of_async_config_prop_packet_in_master */
    8,    /* 277: of_async_config_prop_packet_in_slave */
    8,    /* 278: of_async_config_prop_port_status_master */
    8,    /* 279: of_async_config_prop_port_status_slave */
    8,    /* 280: of_async_config_prop_requestforward_master */
    8,    /* 281: of_async_config_prop_requestforward_slave */
    8,    /* 282: of_async_config_prop_role_status_master */
    8,    /* 283: of_async_config_prop_role_status_slave */
    8,    /* 284: of_async_config_prop_table_status_master */
    8,    /* 285: of_async_config_prop_table_status_slave */
    264,  /* 286: of_bsn_controller_connection */
    328,  /* 287: of_bsn_debug_counter_desc_stats_entry */
    16,   /* 288: of_bsn_debug_counter_stats_entry */
    8,    /* 289: of_bsn_flow_checksum_bucket_stats_entry */
    2,    /* 290: of_bsn_generic_stats_entry */
    16,   /* 291: of_bsn_gentable_bucket_stats_entry */
    48,   /* 292: of_bsn_gentable_desc_stats_entry */
    20,   /* 293: of_bsn_gentable_entry_desc_stats_entry */
    4,    /* 294: of_bsn_gentable_entry_stats_entry */
    24,   /* 295: of_bsn_gentable_stats_entry */
    32,   /* 296: of_bsn_interface */
    36,   /* 297: of_bsn_lacp_stats_entry */
    8,    /* 298: of_bsn_port_counter_stats_entry */
    256,  /* 299: of_bsn_switch_pipeline_stats_entry */
    9,    /* 300: of_bsn_table_checksum_stats_entry */
    4,    /* 301: of_bsn_tlv */
    6,    /* 302: of_bsn_tlv_actor_key */
    6,    /* 303: of_bsn_tlv_actor_port_num */
    6,    /* 304: of_bsn_tlv_actor_port_priority */
    5,    /* 305: of_bsn_tlv_actor_state */
    10,   /* 306: of_bsn_tlv_actor_system_mac */
    6,    /* 307: of_bsn_tlv_actor_system_priority */
    6,    /* 308: of_bsn_tlv_anchor */
    8,    /* 309: of_bsn_tlv_broadcast_query_timeout */
    8,    /* 310: of_bsn_tlv_broadcast_rate */
    4,    /* 311: of_bsn_tlv_bucket */
    4,    /* 312: of_bsn_tlv_circuit_id */
    5,    /* 313: of_bsn_tlv_convergence_status */
    5,    /* 314: of_bsn_tlv_crc_enabled */
    4,    /* 315: of_bsn_tlv_data */
    6,    /* 316: of_bsn_tlv_decap */
    10,   /* 317: of_bsn_tlv_eth_dst */
    10,   /* 318: of_bsn_tlv_eth_src */
    8,    /* 319: of_bsn_tlv_external_gateway_ip */
    10,   /* 320: of_bsn_tlv_external_gateway_mac */
    8,    /* 321: of_bsn_tlv_external_ip */
    10,   /* 322: of_bsn_tlv_external_mac */
    8,    /* 323: of_bsn_tlv_external_netmask */
    12,   /* 324: of_bsn_tlv_generation_id */
    8,    /* 325: of_bsn_tlv_header_size */
    5,    /* 326: of_bsn_tlv_icmp_code */
    6,    /* 327: of_bsn_tlv_icmp_id */
    5,    /* 328: of_bsn_tlv_icmp_type */
    4,    /* 329: of_bsn_tlv_idle_notification */
    12,   /* 330: of_bsn_tlv_idle_time */
    8,    /* 331: of_bsn_tlv_idle_timeout */
    4,    /* 332: of_bsn_tlv_igmp_snooping */
    10,   /* 333: of_bsn_tlv_internal_gateway_mac */
    10,   /* 334: of_bsn_tlv_internal_mac */
    8,    /* 335: of_bsn_tlv_interval */
    5,    /* 336: of_bsn_tlv_ip_proto */
    8,    /* 337: of_bsn_tlv_ipv4 */
    8,    /* 338: of_bsn_tlv_ipv4_dst */
    8,    /* 339: of_bsn_tlv_ipv4_netmask */
    8,    /* 340: of_bsn_tlv_ipv4_src */
    20,   /* 341: of_bsn_tlv_ipv6 */
    8,    /* 342: of_bsn_tlv_known_multicast_rate */
    4,    /* 343: of_bsn_tlv_l2_multicast_lookup */
    10,   /* 344: of_bsn_tlv_mac */
    10,   /* 345: of_bsn_tlv_mac_mask */
    4,    /* 346: of_bsn_tlv_mcg_type_vxlan */
    12,   /* 347: of_bsn_tlv_miss_packets */
    5,    /* 348: of_bsn_tlv_mpls_control_word */
    8,    /* 349: of_bsn_tlv_mpls_label */
    5,    /* 350: of_bsn_tlv_mpls_sequenced */
    8,    /* 351: of_bsn_tlv_multicast_interface_id */
    4,    /* 352: of_bsn_tlv_name */
    4,    /* 353: of_bsn_tlv_negate */
    4,    /* 354: of_bsn_tlv_nexthop_type_vxlan */
    6,    /* 355: of_bsn_tlv_offset */
    6,    /* 356: of_bsn_tlv_partner_key */
    6,    /* 357: of_bsn_tlv_partner_port_num */
    6,    /* 358: of_bsn_tlv_partner_port_priority */
    5,    /* 359: of_bsn_tlv_partner_state */
    10,   /* 360: of_bsn_tlv_partner_system_mac */
    6,    /* 361: of_bsn_tlv_partner_system_priority */
    8,    /* 362: of_bsn_tlv_port */
    5,    /* 363: of_bsn_tlv_port_vxlan_mode */
    8,    /* 364: of_bsn_tlv_priority */
    8,    /* 365: of_bsn_tlv_queue_id */
    8,    /* 366: of_bsn_tlv_queue_weight */
    5,    /* 367: of_bsn_tlv_rate_unit */
    6,    /* 368: of_bsn_tlv_reference */
    12,   /* 369: of_bsn_tlv_reply_packets */
    12,   /* 370: of_bsn_tlv_request_packets */
    12,   /* 371: of_bsn_tlv_rx_bytes */
    12,   /* 372: of_bsn_tlv_rx_packets */
    8,    /* 373: of_bsn_tlv_sampling_rate */
    4,    /* 374: of_bsn_tlv_set_loopback_mode */
    5,    /* 375: of_bsn_tlv_status */
    4,    /* 376: of_bsn_tlv_strip_mpls_l2_on_ingress */
    4,    /* 377: of_bsn_tlv_strip_mpls_l3_on_ingress */
    4,    /* 378: of_bsn_tlv_strip_vlan_on_egress */
    8,    /* 379: of_bsn_tlv_sub_agent_id */
    6,    /* 380: of_bsn_tlv_tcp_dst */
    6,    /* 381: of_bsn_tlv_tcp_src */
    12,   /* 382: of_bsn_tlv_tx_bytes */
    12,   /* 383: of_bsn_tlv_tx_packets */
    6,    /* 384: of_bsn_tlv_udf_anchor */
    6,    /* 385: of_bsn_tlv_udf_id */
    6,    /* 386: of_bsn_tlv_udf_length */
    6,    /* 387: of_bsn_tlv_udf_offset */
    6,    /* 388: of_bsn_tlv_udp_dst */
    6,    /* 389: of_bsn_tlv_udp_src */
    8,    /* 390: of_bsn_tlv_unicast_query_timeout */
    8,    /* 391: of_bsn_tlv_unicast_rate */
    8,    /* 392: of_bsn_tlv_unknown_multicast_rate */
    5,    /* 393: of_bsn_tlv_use_packet_state */
    6,    /* 394: of_bsn_tlv_vfi */
    4,    /* 395: of_bsn_tlv_vlan_mac_list */
    5,    /* 396: of_bsn_tlv_vlan_pcp */
    6,    /* 397: of_bsn_tlv_vlan_vid */
    6,    /* 398: of_bsn_tlv_vlan_vid_mask */
    8,    /* 399: of_bsn_tlv_vni */
    8,    /* 400: of_bsn_tlv_vrf */
    8,    /* 401: of_bsn_vlan_counter_stats_entry */
    8,    /* 402: of_bsn_vlan_mac */
    4,    /* 403: of_bsn_vport */
    64,   /* 404: of_bsn_vport_l2gre */
    32,   /* 405: of_bsn_vport_q_in_q */
    8,    /* 406: of_bsn_vrf_counter_stats_entry */
    16,   /* 407: of_bucket */
    16,   /* 408: of_bucket_counter */
    4,    /* 409: of_bundle_prop */
    12,   /* 410: of_bundle_prop_experimenter */
    56,   /* 411: of_flow_stats_entry */
    8,    /* 412: of_group_desc_stats_entry */
    40,   /* 413: of_group_stats_entry */
    4,    /* 414: of_hello_elem */
    4,    /* 415: of_hello_elem_versionbitmap */
    4,    /* 416: of_instruction */
    8,    /* 417: of_instruction_apply_actions */
    16,   /* 418: of_instruction_bsn */
    16,   /* 419: of_instruction_bsn_arp_offload */
    16,   /* 420: of_instruction_bsn_auto_negotiation */
    16,   /* 421: of_instruction_bsn_deny */
    16,   /* 422: of_instruction_bsn_dhcp_offload */
    16,   /* 423: of_instruction_bsn_disable_l3 */
    -1,   /* 424: of_instruction_bsn_disable_split_horizon_check */
    16,   /* 425: of_instruction_bsn_disable_src_mac_check */
    16,   /* 426: of_instruction_bsn_disable_vlan_counters */
    16,   /* 427: of_instruction_bsn_internal_priority */
    16,   /* 428: of_instruction_bsn_packet_of_death */
    16,   /* 429: of_instruction_bsn_permit */
    16,   /* 430: of_instruction_bsn_prioritize_pdus */
    16,   /* 431: of_instruction_bsn_require_vlan_xlate */
    16,   /* 432: of_instruction_bsn_span_destination */
    8,    /* 433: of_instruction_clear_actions */
    8,    /* 434: of_instruction_experimenter */
    8,    /* 435: of_instruction_goto_table */
    4,    /* 436: of_instruction_id */
    4,    /* 437: of_instruction_id_apply_actions */
    12,   /* 438: of_instruction_id_bsn */
    12,   /* 439: of_instruction_id_bsn_arp_offload */
    12,   /* 440: of_instruction_id_bsn_auto_negotiation */
    12,   /* 441: of_instruction_id_bsn_deny */
    12,   /* 442: of_instruction_id_bsn_dhcp_offload */
    12,   /* 443: of_instruction_id_bsn_disable_l3 */
    -1,   /* 444: of_instruction_id_bsn_disable_split_horizon_check */
    12,   /* 445: of_instruction_id_bsn_disable_src_mac_check */
    12,   /* 446: of_instruction_id_bsn_disable_vlan_counters */
    12,   /* 447: of_instruction_id_bsn_internal_priority */
    12,   /* 448: of_instruction_id_bsn_packet_of_death */
    12,   /* 449: of_instruction_id_bsn_permit */
    12,   /* 450: of_instruction_id_bsn_prioritize_pdus */
    12,   /* 451: of_instruction_id_bsn_require_vlan_xlate */
    12,   /* 452: of_instruction_id_bsn_span_destination */
    4,    /* 453: of_instruction_id_clear_actions */
    8,    /* 454: of_instruction_id_experimenter */
    4,    /* 455: of_instruction_id_goto_table */
    4,    /* 456: of_instruction_id_meter */
    4,    /* 457: of_instruction_id_write_actions */
    4,    /* 458: of_instruction_id_write_metadata */
    8,    /* 459: of_instruction_meter */
    8,    /* 460: of_instruction_write_actions */
    24,   /* 461: of_instruction_write_metadata */
    -1,   /* 462: of_match_v1 */
    -1,   /* 463: of_match_v2 */
    4,    /* 464: of_match_v3 */
    4,    /* 465: of_meter_band */
    16,   /* 466: of_meter_band_drop */
    16,   /* 467: of_meter_band_dscp_remark */
    16,   /* 468: of_meter_band_experimenter */
    16,   /* 469: of_meter_band_stats */
    8,    /* 470: of_meter_config */
    16,   /* 471: of_meter_features */
    40,   /* 472: of_meter_stats */
    4,    /* 473: of_oxm */
    6,    /* 474: of_oxm_arp_op */
    8,    /* 475: of_oxm_arp_op_masked */
    10,   /* 476: of_oxm_arp_sha */
    16,   /* 477: of_oxm_arp_sha_masked */
    8,    /* 478: of_oxm_arp_spa */
    12,   /* 479: of_oxm_arp_spa_masked */
    10,   /* 480: of_oxm_arp_tha */
    16,   /* 481: of_oxm_arp_tha_masked */
    8,    /* 482: of_oxm_arp_tpa */
    12,   /* 483: of_oxm_arp_tpa_masked */
    8,    /* 484: of_oxm_bsn_egr_port_group_id */
    12,   /* 485: of_oxm_bsn_egr_port_group_id_masked */
    -1,   /* 486: of_oxm_bsn_global_vrf_allowed */
    -1,   /* 487: of_oxm_bsn_global_vrf_allowed_masked */
    20,   /* 488: of_oxm_bsn_in_ports_128 */
    36,   /* 489: of_oxm_bsn_in_ports_128_masked */
    68,   /* 490: of_oxm_bsn_in_ports_512 */
    132,  /* 491: of_oxm_bsn_in_ports_512_masked */
    8,    /* 492: of_oxm_bsn_ingress_port_group_id */
    12,   /* 493: of_oxm_bsn_ingress_port_group_id_masked */
    10,   /* 494: of_oxm_bsn_inner_eth_dst */
    16,   /* 495: of_oxm_bsn_inner_eth_dst_masked */
    10,   /* 496: of_oxm_bsn_inner_eth_src */
    16,   /* 497: of_oxm_bsn_inner_eth_src_masked */
    6,    /* 498: of_oxm_bsn_inner_vlan_vid */
    8,    /* 499: of_oxm_bsn_inner_vlan_vid_masked */
    5,    /* 500: of_oxm_bsn_l2_cache_hit */
    6,    /* 501: of_oxm_bsn_l2_cache_hit_masked */
    -1,   /* 502: of_oxm_bsn_l3_dst_class_id */
    -1,   /* 503: of_oxm_bsn_l3_dst_class_id_masked */
    8,    /* 504: of_oxm_bsn_l3_interface_class_id */
    12,   /* 505: of_oxm_bsn_l3_interface_class_id_masked */
    8,    /* 506: of_oxm_bsn_l3_src_class_id */
    12,   /* 507: of_oxm_bsn_l3_src_class_id_masked */
    8,    /* 508: of_oxm_bsn_lag_id */
    12,   /* 509: of_oxm_bsn_lag_id_masked */
    6,    /* 510: of_oxm_bsn_tcp_flags */
    8,    /* 511: of_oxm_bsn_tcp_flags_masked */
    8,    /* 512: of_oxm_bsn_udf0 */
    12,   /* 513: of_oxm_bsn_udf0_masked */
    8,    /* 514: of_oxm_bsn_udf1 */
    12,   /* 515: of_oxm_bsn_udf1_masked */
    8,    /* 516: of_oxm_bsn_udf2 */
    12,   /* 517: of_oxm_bsn_udf2_masked */
    8,    /* 518: of_oxm_bsn_udf3 */
    12,   /* 519: of_oxm_bsn_udf3_masked */
    8,    /* 520: of_oxm_bsn_udf4 */
    12,   /* 521: of_oxm_bsn_udf4_masked */
    8,    /* 522: of_oxm_bsn_udf5 */
    12,   /* 523: of_oxm_bsn_udf5_masked */
    8,    /* 524: of_oxm_bsn_udf6 */
    12,   /* 525: of_oxm_bsn_udf6_masked */
    8,    /* 526: of_oxm_bsn_udf7 */
    12,   /* 527: of_oxm_bsn_udf7_masked */
    8,    /* 528: of_oxm_bsn_vlan_xlate_port_group_id */
    12,   /* 529: of_oxm_bsn_vlan_xlate_port_group_id_masked */
    8,    /* 530: of_oxm_bsn_vrf */
    12,   /* 531: of_oxm_bsn_vrf_masked */
    8,    /* 532: of_oxm_bsn_vxlan_network_id */
    12,   /* 533: of_oxm_bsn_vxlan_network_id_masked */
    10,   /* 534: of_oxm_eth_dst */
    16,   /* 535: of_oxm_eth_dst_masked */
    10,   /* 536: of_oxm_eth_src */
    16,   /* 537: of_oxm_eth_src_masked */
    6,    /* 538: of_oxm_eth_type */
    8,    /* 539: of_oxm_eth_type_masked */
    5,    /* 540: of_oxm_icmpv4_code */
    6,    /* 541: of_oxm_icmpv4_code_masked */
    5,    /* 542: of_oxm_icmpv4_type */
    6,    /* 543: of_oxm_icmpv4_type_masked */
    5,    /* 544: of_oxm_icmpv6_code */
    6,    /* 545: of_oxm_icmpv6_code_masked */
    5,    /* 546: of_oxm_icmpv6_type */
    6,    /* 547: of_oxm_icmpv6_type_masked */
    8,    /* 548: of_oxm_in_phy_port */
    12,   /* 549: of_oxm_in_phy_port_masked */
    8,    /* 550: of_oxm_in_port */
    12,   /* 551: of_oxm_in_port_masked */
    5,    /* 552: of_oxm_ip_dscp */
    6,    /* 553: of_oxm_ip_dscp_masked */
    5,    /* 554: of_oxm_ip_ecn */
    6,    /* 555: of_oxm_ip_ecn_masked */
    5,    /* 556: of_oxm_ip_proto */
    6,    /* 557: of_oxm_ip_proto_masked */
    8,    /* 558: of_oxm_ipv4_dst */
    12,   /* 559: of_oxm_ipv4_dst_masked */
    8,    /* 560: of_oxm_ipv4_src */
    12,   /* 561: of_oxm_ipv4_src_masked */
    20,   /* 562: of_oxm_ipv6_dst */
    36,   /* 563: of_oxm_ipv6_dst_masked */
    6,    /* 564: of_oxm_ipv6_exthdr */
    8,    /* 565: of_oxm_ipv6_exthdr_masked */
    8,    /* 566: of_oxm_ipv6_flabel */
    12,   /* 567: of_oxm_ipv6_flabel_masked */
    10,   /* 568: of_oxm_ipv6_nd_sll */
    16,   /* 569: of_oxm_ipv6_nd_sll_masked */
    20,   /* 570: of_oxm_ipv6_nd_target */
    36,   /* 571: of_oxm_ipv6_nd_target_masked */
    10,   /* 572: of_oxm_ipv6_nd_tll */
    16,   /* 573: of_oxm_ipv6_nd_tll_masked */
    20,   /* 574: of_oxm_ipv6_src */
    36,   /* 575: of_oxm_ipv6_src_masked */
    12,   /* 576: of_oxm_metadata */
    20,   /* 577: of_oxm_metadata_masked */
    5,    /* 578: of_oxm_mpls_bos */
    6,    /* 579: of_oxm_mpls_bos_masked */
    8,    /* 580: of_oxm_mpls_label */
    12,   /* 581: of_oxm_mpls_label_masked */
    5,    /* 582: of_oxm_mpls_tc */
    6,    /* 583: of_oxm_mpls_tc_masked */
    5,    /* 584: of_oxm_pbb_uca */
    6,    /* 585: of_oxm_pbb_uca_masked */
    6,    /* 586: of_oxm_sctp_dst */
    8,    /* 587: of_oxm_sctp_dst_masked */
    6,    /* 588: of_oxm_sctp_src */
    8,    /* 589: of_oxm_sctp_src_masked */
    6,    /* 590: of_oxm_tcp_dst */
    8,    /* 591: of_oxm_tcp_dst_masked */
    6,    /* 592: of_oxm_tcp_src */
    8,    /* 593: of_oxm_tcp_src_masked */
    12,   /* 594: of_oxm_tunnel_id */
    20,   /* 595: of_oxm_tunnel_id_masked */
    8,    /* 596: of_oxm_tunnel_ipv4_dst */
    12,   /* 597: of_oxm_tunnel_ipv4_dst_masked */
    8,    /* 598: of_oxm_tunnel_ipv4_src */
    12,   /* 599: of_oxm_tunnel_ipv4_src_masked */
    6,    /* 600: of_oxm_udp_dst */
    8,    /* 601: of_oxm_udp_dst_masked */
    6,    /* 602: of_oxm_udp_src */
    8,    /* 603: of_oxm_udp_src_masked */
    5,    /* 604: of_oxm_vlan_pcp */
    6,    /* 605: of_oxm_vlan_pcp_masked */
    6,    /* 606: of_oxm_vlan_vid */
    8,    /* 607: of_oxm_vlan_vid_masked */
    16,   /* 608: of_packet_queue */
    40,   /* 609: of_port_desc */
    4,    /* 610: of_port_desc_prop */
    12,   /* 611: of_port_desc_prop_bsn */
    20,   /* 612: of_port_desc_prop_bsn_generation_id */
    12,   /* 613: of_port_desc_prop_bsn_uplink */
    32,   /* 614: of_port_desc_prop_ethernet */
    8,    /* 615: of_port_desc_prop_experimenter */
    44,   /* 616: of_port_desc_prop_optical */
    4,    /* 617: of_port_mod_prop */
    8,    /* 618: of_port_mod_prop_ethernet */
    12,   /* 619: of_port_mod_prop_experimenter */
    24,   /* 620: of_port_mod_prop_optical */
    80,   /* 621: of_port_stats_entry */
    4,    /* 622: of_port_stats_prop */
    40,   /* 623: of_port_stats_prop_ethernet */
    12,   /* 624: of_port_stats_prop_experimenter */
    44,   /* 625: of_port_stats_prop_optical */
    16,   /* 626: of_queue_desc */
    4,    /* 627: of_queue_desc_prop */
    12,   /* 628: of_queue_desc_prop_experimenter */
    8,    /* 629: of_queue_desc_prop_max_rate */
    8,    /* 630: of_queue_desc_prop_min_rate */
    8,    /* 631: of_queue_prop */
    16,   /* 632: of_queue_prop_experimenter */
    16,   /* 633: of_queue_prop_max_rate */
    16,   /* 634: of_queue_prop_min_rate */
    48,   /* 635: of_queue_stats_entry */
    4,    /* 636: of_queue_stats_prop */
    12,   /* 637: of_queue_stats_prop_experimenter */
    4,    /* 638: of_role_prop */
    12,   /* 639: of_role_prop_experimenter */
    8,    /* 640: of_table_desc */
    4,    /* 641: of_table_feature_prop */
    4,    /* 642: of_table_feature_prop_apply_actions */
    4,    /* 643: of_table_feature_prop_apply_actions_miss */
    4,    /* 644: of_table_feature_prop_apply_setfield */
    4,    /* 645: of_table_feature_prop_apply_setfield_miss */
    12,   /* 646: of_table_feature_prop_experimenter */
    12,   /* 647: of_table_feature_prop_experimenter_miss */
    4,    /* 648: of_table_feature_prop_instructions */
    4,    /* 649: of_table_feature_prop_instructions_miss */
    4,    /* 650: of_table_feature_prop_match */
    4,    /* 651: of_table_feature_prop_next_tables */
    4,    /* 652: of_table_feature_prop_next_tables_miss */
    4,    /* 653: of_table_feature_prop_table_sync_from */
    4,    /* 654: of_table_feature_prop_wildcards */
    4,    /* 655: of_table_feature_prop_write_actions */
    4,    /* 656: of_table_feature_prop_write_actions_miss */
    4,    /* 657: of_table_feature_prop_write_setfield */
    4,    /* 658: of_table_feature_prop_write_setfield_miss */
    64,   /* 659: of_table_features */
    4,    /* 660: of_table_mod_prop */
    8,    /* 661: of_table_mod_prop_eviction */
    12,   /* 662: of_table_mod_prop_experimenter */
    8,    /* 663: of_table_mod_prop_vacancy */
    24,   /* 664: of_table_stats_entry */
    4,    /* 665: of_uint32 */
    8,    /* 666: of_uint64 */
    1,    /* 667: of_uint8 */
    0,    /* 668: of_list_action */
    0,    /* 669: of_list_action_id */
    0,    /* 670: of_list_async_config_prop */
    0,    /* 671: of_list_bsn_controller_connection */
    0,    /* 672: of_list_bsn_debug_counter_desc_stats_entry */
    0,    /* 673: of_list_bsn_debug_counter_stats_entry */
    0,    /* 674: of_list_bsn_flow_checksum_bucket_stats_entry */
    0,    /* 675: of_list_bsn_generic_stats_entry */
    0,    /* 676: of_list_bsn_gentable_bucket_stats_entry */
    0,    /* 677: of_list_bsn_gentable_desc_stats_entry */
    0,    /* 678: of_list_bsn_gentable_entry_desc_stats_entry */
    0,    /* 679: of_list_bsn_gentable_entry_stats_entry */
    0,    /* 680: of_list_bsn_gentable_stats_entry */
    0,    /* 681: of_list_bsn_interface */
    0,    /* 682: of_list_bsn_lacp_stats_entry */
    0,    /* 683: of_list_bsn_port_counter_stats_entry */
    0,    /* 684: of_list_bsn_switch_pipeline_stats_entry */
    0,    /* 685: of_list_bsn_table_checksum_stats_entry */
    0,    /* 686: of_list_bsn_tlv */
    0,    /* 687: of_list_bsn_vlan_counter_stats_entry */
    0,    /* 688: of_list_bsn_vlan_mac */
    0,    /* 689: of_list_bsn_vrf_counter_stats_entry */
    0,    /* 690: of_list_bucket */
    0,    /* 691: of_list_bucket_counter */
    0,    /* 692: of_list_bundle_prop */
    0,    /* 693: of_list_flow_stats_entry */
    0,    /* 694: of_list_group_desc_stats_entry */
    0,    /* 695: of_list_group_stats_entry */
    0,    /* 696: of_list_hello_elem */
    0,    /* 697: of_list_instruction */
    0,    /* 698: of_list_instruction_id */
    0,    /* 699: of_list_meter_band */
    0,    /* 700: of_list_meter_band_stats */
    0,    /* 701: of_list_meter_config */
    0,    /* 702: of_list_meter_stats */
    0,    /* 703: of_list_oxm */
    -1,   /* 704: of_list_packet_queue */
    0,    /* 705: of_list_port_desc */
    0,    /* 706: of_list_port_desc_prop */
    0,    /* 707: of_list_port_mod_prop */
    0,    /* 708: of_list_port_stats_entry */
    0,    /* 709: of_list_port_stats_prop */
    0,    /* 710: of_list_queue_desc */
    0,    /* 711: of_list_queue_desc_prop */
    0,    /* 712: of_list_queue_prop */
    0,    /* 713: of_list_queue_stats_entry */
    0,    /* 714: of_list_queue_stats_prop */
    0,    /* 715: of_list_role_prop */
    0,    /* 716: of_list_table_desc */
    0,    /* 717: of_list_table_feature_prop */
    0,    /* 718: of_list_table_features */
    0,    /* 719: of_list_table_mod_prop */
    0,    /* 720: of_list_table_stats_entry */
    0,    /* 721: of_list_uint32 */
    0,    /* 722: of_list_uint64 */
    0     /* 723: of_list_uint8 */
};

/**
 * Unified map of fixed length part of each object
 */
const int *const of_object_fixed_len[OF_VERSION_ARRAY_MAX] = {
    NULL,
    of_object_fixed_len_v1,
    of_object_fixed_len_v2,
    of_object_fixed_len_v3,
    of_object_fixed_len_v4,
    of_object_fixed_len_v5,

};


/****************************************************************
 * Top level OpenFlow message length functions
 ****************************************************************/

/**
 * Get the length of a message object as reported on the wire
 * @param obj The object to check
 * @param bytes (out) Where the length is stored
 * @returns OF_ERROR_ code
 */
void
of_object_message_wire_length_get(of_object_t *obj, int *bytes)
{
    LOCI_ASSERT(OF_OBJECT_TO_WBUF(obj) != NULL);
    // LOCI_ASSERT(obj is message)
    *bytes = of_message_length_get(OF_OBJECT_TO_MESSAGE(obj));
}

/**
 * Set the length of a message object as reported on the wire
 * @param obj The object to check
 * @param bytes The new length of the object
 * @returns OF_ERROR_ code
 */
void
of_object_message_wire_length_set(of_object_t *obj, int bytes)
{
    LOCI_ASSERT(OF_OBJECT_TO_WBUF(obj) != NULL);
    // LOCI_ASSERT(obj is message)
    of_message_length_set(OF_OBJECT_TO_MESSAGE(obj), bytes);
}

/****************************************************************
 * TLV16 type/length functions
 ****************************************************************/

/**
 * Many objects are TLVs and use uint16 for the type and length values
 * stored on the wire at the beginning of the buffer.
 */
#define TLV16_WIRE_TYPE_OFFSET 0
#define TLV16_WIRE_LENGTH_OFFSET 2

/**
 * Get the length field from the wire for a standard TLV
 * object that uses uint16 for both type and length.
 * @param obj The object being referenced
 * @param bytes (out) Where to store the length
 */

void
of_tlv16_wire_length_get(of_object_t *obj, int *bytes)
{
    uint16_t val16;
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_get(wbuf, 
           OF_OBJECT_ABSOLUTE_OFFSET(obj, TLV16_WIRE_LENGTH_OFFSET), &val16);
    *bytes = val16;
}

/**
 * Set the length field in the wire buffer for a standard TLV
 * object that uses uint16 for both type and length.
 * @param obj The object being referenced
 * @param bytes The length value to use
 */

void
of_tlv16_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_set(wbuf, 
        OF_OBJECT_ABSOLUTE_OFFSET(obj, TLV16_WIRE_LENGTH_OFFSET), bytes);
}


/****************************************************************
 * OXM type/length functions.
 ****************************************************************/

/* Where does the OXM type-length header lie in the buffer */
#define OXM_HDR_OFFSET 0

/**
 * Get the OXM header (type-length fields) from the wire buffer
 * associated with an OXM object
 *
 * Will return if error; set hdr to the OXM header
 */

#define _GET_OXM_TYPE_LEN(obj, tl_p, wbuf) do {                         \
        wbuf = OF_OBJECT_TO_WBUF(obj);                                  \
        LOCI_ASSERT(wbuf != NULL);                                           \
        of_wire_buffer_u32_get(wbuf,                                    \
            OF_OBJECT_ABSOLUTE_OFFSET(obj, OXM_HDR_OFFSET), (tl_p));    \
    } while (0)

#define _SET_OXM_TYPE_LEN(obj, tl_p, wbuf) do {                         \
        wbuf = OF_OBJECT_TO_WBUF(obj);                                  \
        LOCI_ASSERT(wbuf != NULL);                                           \
        of_wire_buffer_u32_set(wbuf,                                    \
            OF_OBJECT_ABSOLUTE_OFFSET(obj, OXM_HDR_OFFSET), (tl_p));    \
    } while (0)

/**
 * Get the length of an OXM object from the wire buffer
 * @param obj The object whose wire buffer is an OXM type
 * @param bytes (out) Where length is stored 
 */

void
of_oxm_wire_length_get(of_object_t *obj, int *bytes)
{
    uint32_t type_len;
    of_wire_buffer_t *wbuf;

    _GET_OXM_TYPE_LEN(obj, &type_len, wbuf);
    *bytes = OF_OXM_LENGTH_GET(type_len);
}

#define OF_U16_LEN_LENGTH_OFFSET 0

/**
 * Get the wire length for an object with a uint16 length as first member
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 */
void
of_u16_len_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;

    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_get(wbuf, 
           OF_OBJECT_ABSOLUTE_OFFSET(obj, OF_U16_LEN_LENGTH_OFFSET),
           &u16);

    *bytes = u16;
}

/**
 * Set the wire length for an object with a uint16 length as first member
 * @param obj The object being referenced
 * @param bytes The length of the object
 */

void
of_u16_len_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    /* LOCI_ASSERT(obj is u16-len entry) */

    of_wire_buffer_u16_set(wbuf, 
           OF_OBJECT_ABSOLUTE_OFFSET(obj, OF_U16_LEN_LENGTH_OFFSET),
           bytes);
}


#define OF_PACKET_QUEUE_LENGTH_OFFSET(ver) \
    (((ver) >= OF_VERSION_1_2) ? 8 : 4)

/**
 * Get the wire length for a packet queue object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * The length is a uint16 at the offset indicated above
 */
void
of_packet_queue_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;
    int offset;

    LOCI_ASSERT(wbuf != NULL);

    /* LOCI_ASSERT(obj is packet queue obj) */
    offset = OF_PACKET_QUEUE_LENGTH_OFFSET(obj->version);
    of_wire_buffer_u16_get(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, offset),
                           &u16);

    *bytes = u16;
}

/**
 * Set the wire length for a 1.2 packet queue object
 * @param obj The object being referenced
 * @param bytes The length of the object
 *
 * The length is a uint16 at the offset indicated above
 */

void
of_packet_queue_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    int offset;

    LOCI_ASSERT(wbuf != NULL);

    /* LOCI_ASSERT(obj is packet queue obj) */
    offset = OF_PACKET_QUEUE_LENGTH_OFFSET(obj->version);
    of_wire_buffer_u16_set(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, offset),
                                  bytes);
}

/**
 * Get the wire length for a meter band stats list
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * Must a meter_stats object as a parent
 */

void
of_list_meter_band_stats_wire_length_get(of_object_t *obj, int *bytes)
{
    LOCI_ASSERT(obj->parent != NULL);
    LOCI_ASSERT(obj->parent->object_id == OF_METER_STATS);

    /* We're counting on the parent being properly initialized already.
     * The length is stored in a uint16 at offset 4 of the parent.
     */
    *bytes = obj->parent->length - OF_OBJECT_FIXED_LENGTH(obj->parent);
}

#define OF_METER_STATS_LENGTH_OFFSET 4

/**
 * Get/set the wire length for a meter stats object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * It's almost a TLV....
 */

void
of_meter_stats_wire_length_get(of_object_t *obj, int *bytes)
{
    uint16_t val16;
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);
    of_wire_buffer_u16_get(wbuf, 
               OF_OBJECT_ABSOLUTE_OFFSET(obj, OF_METER_STATS_LENGTH_OFFSET),
               &val16);
    *bytes = val16;
}

void
of_meter_stats_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_set(wbuf, 
        OF_OBJECT_ABSOLUTE_OFFSET(obj, OF_METER_STATS_LENGTH_OFFSET), bytes);
}

/**
 * Get the wire length for a port desc object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * The length is only present for OF 1.4+.
 */
void
of_port_desc_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;

    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_get(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 4),
                               &u16);
        *bytes = u16;
    } else {
        *bytes = OF_OBJECT_FIXED_LENGTH(obj);
    }
}

/**
 * Set the wire length for a port desc object
 * @param obj The object being referenced
 * @param bytes The length of the object
 *
 * The length is only present for OF 1.4+.
 */

void
of_port_desc_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_set(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 4),
                               bytes);
    } else {
        LOCI_ASSERT(obj->length == OF_OBJECT_FIXED_LENGTH(obj));
    }
}

/**
 * Get the wire length for a port stats_entry object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * The length is only present for OF 1.4+.
 */
void
of_port_stats_entry_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;

    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_get(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 0),
                               &u16);
        *bytes = u16;
    } else {
        *bytes = OF_OBJECT_FIXED_LENGTH(obj);
    }
}

/**
 * Set the wire length for a port stats_entry object
 * @param obj The object being referenced
 * @param bytes The length of the object
 *
 * The length is only present for OF 1.4+.
 */

void
of_port_stats_entry_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_set(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 0),
                               bytes);
    } else {
        LOCI_ASSERT(obj->length == OF_OBJECT_FIXED_LENGTH(obj));
    }
}

/**
 * Get the wire length for a queue stats_entry object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 *
 * The length is only present for OF 1.4+.
 */
void
of_queue_stats_entry_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;

    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_get(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 0),
                               &u16);
        *bytes = u16;
    } else {
        *bytes = OF_OBJECT_FIXED_LENGTH(obj);
    }
}

/**
 * Set the wire length for a queue stats_entry object
 * @param obj The object being referenced
 * @param bytes The length of the object
 *
 * The length is only present for OF 1.4+.
 */

void
of_queue_stats_entry_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    if (obj->version >= OF_VERSION_1_4) {
        of_wire_buffer_u16_set(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 0),
                               bytes);
    } else {
        LOCI_ASSERT(obj->length == OF_OBJECT_FIXED_LENGTH(obj));
    }
}

/**
 * Get the wire length for a queue_desc object
 * @param obj The object being referenced
 * @param bytes Pointer to location to store length
 */
void
of_queue_desc_wire_length_get(of_object_t *obj, int *bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    uint16_t u16;

    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_get(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 8), &u16);
    *bytes = u16;
}

/**
 * Set the wire length for a queue_desc object
 * @param obj The object being referenced
 * @param bytes The length of the object
 */

void
of_queue_desc_wire_length_set(of_object_t *obj, int bytes)
{
    of_wire_buffer_t *wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    of_wire_buffer_u16_set(wbuf, OF_OBJECT_ABSOLUTE_OFFSET(obj, 8), bytes);
}
