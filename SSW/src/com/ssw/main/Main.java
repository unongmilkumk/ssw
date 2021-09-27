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
		System.out.println("??¬κ·ΈμΈ?΄ ??±? ???΅??€.");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		System.out.println("??¬κ·ΈμΈ?΄ λΉν?±? ???΅??€.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")) {
			if(sender instanceof Player) {
				sender.sendMessage("??¬κ·ΈμΈ ??" + ChatColor.YELLOW);
				return false;
			}
			sender.sendMessage("========================" + "\r  \n" 
					+ "                μ½μμ°½μ? ?? ₯???΅??€." + "\r\n" +ChatColor.RED
					+ "                ?? ?΄?΄κ°? μΉμκΈ? λ°λ??€." + "\r\n" +ChatColor.WHITE 
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
				P.sendMessage("?Ή? ?κ²λ OPκ°? ??΅??€. κ΄?λ¦¬μ?κ²? λΆ???΄λ³΄μΈ?" +ChatColor.AQUA);
				return false;
			}
		}
		if(cmd.getName().equalsIgnoreCase("ssw")) {
			Player P = (Player) sender;
				if(args.length == 0)  {
					P.sendMessage("ssw job : ?Ό??₯? ₯?? ?₯? ₯ λͺ©λ‘? λ³? ? ??.");
					P.sendMessage("ssw job <?₯? ₯> : ?Ό??₯? ₯?? ?₯? ₯? λ³? ? ??.");
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
								P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" unongmilk" +ChatColor.AQUA + " : ? ?€ μ§μ?΄λ©? μ΄κ°? ₯ λ°©λ²?Όλ‘? ?λ°©μ ?Έ?€.");
							}
							if(args[1].equalsIgnoreCase("Alldone")) {
								P.sendMessage(ChatColor.YELLOW +"[S]" +ChatColor.GREEN +" Alldone" +ChatColor.AQUA + " : ?? μ§μ?΄λ©? λ―Όμ²©? λͺΈμΌλ‘? ??΄??€.");
							}
							if(args[1].equalsIgnoreCase("kamgyul")) {
								P.sendMessage(ChatColor.YELLOW +"[L]" +ChatColor.GREEN +" kamgyul" +ChatColor.AQUA + " : κ°λ €?¬? ?₯λΉλ?? κ°?μ§?κ³? ?°?΄λ²λ¦°?€.");
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
