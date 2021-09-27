package com.ssw.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;



public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("?”Œ?Ÿ¬ê·¸ì¸?´ ?™œ?„±?™” ?˜?—ˆ?Šµ?‹ˆ?‹¤.");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		System.out.println("?”Œ?Ÿ¬ê·¸ì¸?´ ë¹„í™œ?„±?™” ?˜?—ˆ?Šµ?‹ˆ?‹¤.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")) {
			if(sender instanceof Player) {
				sender.sendMessage("?”Œ?Ÿ¬ê·¸ì¸ ?‘?™" + ChatColor.YELLOW);
				return false;
			}
			sender.sendMessage("========================" + "\r  \n" 
					+ "                ì½˜ì†”ì°½ì—?„œ ?…? ¥?˜?—ˆ?Šµ?‹ˆ?‹¤." + "\r\n" +ChatColor.RED
					+ "                ?”Œ? ˆ?´?–´ê°? ì¹˜ì‹œê¸? ë°”ë?‹ˆ?‹¤." + "\r\n" +ChatColor.WHITE 
					+ "                 ========================");
			return false;
		}
		if(cmd.getName().equalsIgnoreCase("fly")) {
			Player P = (Player) sender;
			if (P.isOp()) {
				if (P.getAllowFlight()) {
						P.setAllowFlight(false);
				}
				else {
					P.setAllowFlight(true);
				}
				return false;
			}
			else {
				P.sendMessage("?‹¹?‹ ?—ê²ŒëŠ” OPê°? ?—†?Šµ?‹ˆ?‹¤. ê´?ë¦¬ì?—ê²? ë¶??ƒ?•´ë³´ì„¸?š”" +ChatColor.AQUA);
				return false;
			}
		}
		if(cmd.getName().equalsIgnoreCase("ssw")) {
			Player P = (Player) sender;
				if(args.length == 0)  {
					P.sendMessage("ssw job : ?•¼?ƒ?Š¥? ¥??˜ ?Š¥? ¥ ëª©ë¡?„ ë³? ?ˆ˜ ?ˆ?Œ.");
					P.sendMessage("ssw job <?Š¥? ¥> : ?•¼?ƒ?Š¥? ¥??˜ ?Š¥? ¥?„ ë³? ?ˆ˜ ?ˆ?Œ.");
				}
				else {
					if(args[0].equalsIgnoreCase("job")) {
						if(args.length == 1)  {
							P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" unongmilk");
							P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" kamgyul");
							P.sendMessage(ChatColor.YELLOW +"[S]" +ChatColor.GREEN +" Alldone");
						}
						else {
							if(args[1].equalsIgnoreCase("unongmilk")) {
								P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" unongmilk" +ChatColor.AQUA + " : ? „?„¤ ì§ì—…?´ë©? ì´ˆê°•? ¥ ë°©ë²•?œ¼ë¡? ?•œë°©ì„ ?‚¸?‹¤.");
							}
							if(args[1].equalsIgnoreCase("Alldone")) {
								P.sendMessage(ChatColor.YELLOW +"[S]" +ChatColor.GREEN +" Alldone" +ChatColor.AQUA + " : ?˜?›… ì§ì—…?´ë©? ë¯¼ì²©?•œ ëª¸ìœ¼ë¡? ?•™?‚´?•œ?‹¤.");
							}
							if(args[1].equalsIgnoreCase("kamgyul")) {
								P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" kamgyul" +ChatColor.AQUA + " : ê°•ë ¤?¬?•œ ?¥ë¹„ë?? ê°?ì§?ê³? ?°?–´ë²„ë¦°?‹¤.");
							}
						}
					}
				}
			return false;
		}
	
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void rightClick1(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
		{
			if(p.getItemInHand().getType() == Material.FIRE_CHARGE)
			{
				Fireball fb = p.launchProjectile(Fireball.class);
				fb.setVelocity(p.getLocation().getDirection().multiply(1));
			}
			if(p.getItemInHand().getType() == Material.EMERALD)
			{
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 4));
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 2));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 2));
			}
			if(p.getItemInHand().getType() == Material.COPPER_INGOT)
			{
				p.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD));
				p.getInventory().addItem(new ItemStack(Material.NETHERITE_HELMET));
				p.getInventory().addItem(new ItemStack(Material.NETHERITE_CHESTPLATE));
				p.getInventory().addItem(new ItemStack(Material.NETHERITE_LEGGINGS));
				p.getInventory().addItem(new ItemStack(Material.NETHERITE_BOOTS));
			}
			if(p.getItemInHand().getType() == Material.IRON_SWORD)
			{
				p.setVelocity(p.getLocation().getDirection());
			}
			if(p.getItemInHand().getType() == Material.BOOK)
			{
				int randomPlayerNumber = new Random().nextInt(Bukkit.getServer().getOnlinePlayers().size());
				Player random = (Player) Bukkit.getOnlinePlayers().toArray()[randomPlayerNumber];
				p.teleport(random.getLocation());
			}
			if(p.getItemInHand().getType() == Material.DIAMOND) {
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
			}
		}
	}

}
